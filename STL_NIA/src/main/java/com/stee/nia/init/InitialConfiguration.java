package com.stee.nia.init;

import com.google.common.collect.Lists;
import com.stee.nia.repository.ConnectionParamsRepository;
import com.stee.nia.repository.LampPointMeaningsRepository;
import com.stee.nia.service.impl.RealTimeServiceImpl;
import com.stee.nia.websocket.MySocketHandler;
import com.stee.sel.nia.ConnectionParams;
import com.stee.sel.nia.LampPointMeanings;
import org.eclipse.jetty.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
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
    public static long interval = 5;
    public static Integer webSocketMode = 0;
    @Autowired
    RealTimeServiceImpl realTimeService;
    @Autowired
    ConnectionParamsRepository repository;
    @Autowired
    LampPointMeaningsRepository meaningsRepository;
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
    ResourceBundle resource = ResourceBundle.getBundle("config");

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
        // CMS-NMS连接参数
        List<ConnectionParams> params = Lists.newArrayList();
        Properties niaProps = new Properties();
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("nia-config.properties");
            niaProps.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        niaProps.forEach((o, o2) -> {
            ConnectionParams connectionParams = new ConnectionParams();
            connectionParams.setKey(o.toString());
            connectionParams.setValue(o2.toString());
            params.add(connectionParams);
            realTimeService.map.put(o.toString(), o2.toString());
        });
        repository.deleteAll();
        repository.save(params);

        // LampMeaning
        List<LampPointMeanings> meaningss = Lists.newArrayList();
        meaningsRepository.deleteAll();
        Properties properties = new Properties();
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("meaning-config.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.forEach((o, o2) -> {
            LampPointMeanings lampPointMeanings = new LampPointMeanings();
            lampPointMeanings.setId(Integer.valueOf(o.toString()).intValue());
            lampPointMeanings.setMeaning(o2.toString());
            meaningss.add(lampPointMeanings);
        });
        meaningss.sort(((o1, o2) -> o1.getId().compareTo(o2.getId())));
        meaningsRepository.save(meaningss);

        realTimeService.assembles.addAll(meaningss);

    }

    private void initPollingTimer() {
        Integer obj = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            obj = restTemplate.getForObject(resource.getString("scm.rest.get.value") + "Polling_Interval", Integer.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (null != obj) {
            try {
                interval = obj;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.scheduleAtFixedRate(() -> realTimeService.getPollingStatus(), 0, interval, TimeUnit.MINUTES);
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
