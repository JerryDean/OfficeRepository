package com.stee.nia.init;

import com.google.common.collect.Sets;
import com.stee.nia.repository.ConnectionParamsRepository;
import com.stee.nia.service.impl.RealTimeServiceImpl;
import com.stee.nia.websocket.MySocketHandler;
import com.stee.sel.nia.ConnectionParams;
import org.eclipse.jetty.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_NIA
 * File Name    : InitialConfiguration.java
 * Author       : Jerry
 * Created      : 2016年11月17日 下午8:58:37
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Component
public class InitialConfiguration implements CommandLineRunner {
    @Autowired
    RealTimeServiceImpl realTimeService;

    @Autowired
    ConnectionParamsRepository repository;

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    ResourceBundle resource = ResourceBundle.getBundle("config");

    public static long interval = 5;

    public static Integer webSocketMode = 0;

    @Override
    public void run(String... arg0) throws Exception {
        webSocketMode = Integer.valueOf(resource.getString("websocket.mode"));
        // 初始化CMS-NMS连接参数
        initProperties();
        // 初始化轮询任务
        initPollingTimer();
        // 初始化WebSocket
        initWebSocket();
    }

    private void initProperties() {
        List<ConnectionParams> findAll = repository.findAll();
        if (null != findAll && !findAll.isEmpty() && findAll.size() >= 7) {
            findAll.forEach(t -> {
                realTimeService.map.put(t.getKey(), t.getValue());
            });
        } else {
            Properties properties = new Properties();
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("nia-config.properties");
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!properties.entrySet().isEmpty()) {
                repository.deleteAll();
                Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
                Set<ConnectionParams> connectionParamsSet = Sets.newHashSet();
                while (iterator.hasNext()) {
                    Map.Entry<Object, Object> next = iterator.next();
                    ConnectionParams connectionParams = new ConnectionParams();
                    connectionParams.setKey(next.getKey().toString());
                    connectionParams.setValue(next.getValue().toString());
                    connectionParamsSet.add(connectionParams);
                }
                if (null != connectionParamsSet && !connectionParamsSet.isEmpty()) {
                    repository.save(connectionParamsSet);
                    //将配置文件中的配置存入Map 中
                    connectionParamsSet.forEach(param -> {
                        realTimeService.map.put(param.getKey(), param.getValue());
                    });
                }
            } else {
                // TODO: 2016/12/14 从数据库获取数据，并写入Properties
            }
        }
    }

    private void initPollingTimer() {
        Integer obj = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            obj = restTemplate.getForObject(resource.getString("scm.rest.get.value") + "Polling_Interval", Integer.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            obj = 5;
        }
        if (null != obj) {
            try {
                interval = obj;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.scheduleAtFixedRate(() -> {
            realTimeService.getPollingStatus();
        }, 0, interval, TimeUnit.MINUTES);
    }

    private void initWebSocket() {
        Server server = new Server(Integer.parseInt(resource.getString("socket.port")));
        server.setHandler(new MySocketHandler());
        server.setStopTimeout(0);
        try {
            server.start();
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
