package com.stee.nia.websocket;

import com.google.gson.Gson;
import com.stee.nia.repository.LampInfoRepository;
import com.stee.sel.constant.OperationState;
import com.stee.sel.lim.status.EnergyUsage;
import com.stee.sel.lim.status.LampStatus;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;

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
 * File Name    : MySocketHandler.java
 * Author       : Jerry
 * Created      : 2016年11月23日 下午2:03:19
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@WebSocket
public class MySocketHandler extends WebSocketHandler {

    @Autowired
    LampInfoRepository repository;

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println("Connect....");
    }

    @OnWebSocketClose
    public void onClose(int status, String reason) {
        System.out.println(status + ":" + reason);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) throws IOException {
        Gson gson = new Gson();
        boolean flag = true;
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LampStatus lampStatus = new LampStatus();
            if (flag) {
                lampStatus.setVoltage(14.3f);
                lampStatus.setPowerFactor(13f);
                lampStatus.setLampSwitch(false);
                lampStatus.setActivePower(14.13f);
                lampStatus.setApparentPower(14.33f);
                lampStatus.setBurningHour(5000);
                lampStatus.setCurrentFlow(12f);
                lampStatus.setEnergyUsage(new EnergyUsage(14d, new Date()));
                lampStatus.setReactivePower(14.5f);
                lampStatus.setTemperature(53f);
                lampStatus.setInstalledDate(new Date());
                lampStatus.setOperationState(OperationState.Unknown);
                lampStatus.setLampLevel(75);
                lampStatus.setNodeFailureMessage(null);
            } else {
                lampStatus.setVoltage(24.3f);
                lampStatus.setPowerFactor(14f);
                lampStatus.setLampSwitch(true);
                lampStatus.setActivePower(43.13f);
                lampStatus.setApparentPower(24.33f);
                lampStatus.setBurningHour(6000);
                lampStatus.setCurrentFlow(12f);
                lampStatus.setEnergyUsage(new EnergyUsage(14d, new Date()));
                lampStatus.setReactivePower(14.7f);
                lampStatus.setTemperature(54f);
                lampStatus.setInstalledDate(new Date());
                lampStatus.setOperationState(OperationState.CommsFailure);
                lampStatus.setLampLevel(100);
                lampStatus.setNodeFailureMessage(null);
            }
            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setType("lampStatus");
            statusResponse.setObject(lampStatus);
            flag = !flag;
            session.getRemote().sendString(gson.toJson(statusResponse));
        }
    }

    class StatusResponse {
        private String type;
        private LampStatus object;

        @Override
        public String toString() {
            return "StatusResponse{" +
                    "type='" + type + '\'' +
                    ", object=" + object +
                    '}';
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public LampStatus getObject() {
            return object;
        }

        public void setObject(LampStatus object) {
            this.object = object;
        }
    }

    class StatusRequest {
        private String type;
        private String id;

        @Override
        public String toString() {
            return "StatusRequest{" +
                    "type='" + type + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.register(this.getClass());
    }

}
