package com.stee.nia.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.stee.nia.init.InitialConfiguration;
import com.stee.nia.repository.LampInfoRepository;
import com.stee.sel.lim.LampInfo;
import com.stee.sel.lim.status.LampStatus;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

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

	@OnWebSocketMessage
	public void onMessage(Session session, String message) throws IOException {
        Gson gson = new Gson();
        StatusRequest statusRequest = gson.fromJson(message, StatusRequest.class);
        System.out.println(statusRequest);
        String type = statusRequest.getType();
        String id = statusRequest.getId();
        if (type.equals("lampStatus")) {
            long interval = InitialConfiguration.interval;
            while (true) {
                try {
                    Thread.sleep(interval * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LampInfo lampInfo = repository.findOne(id);
                LampStatus lampStatus = lampInfo.getLampStatus();
                ObjectMapper objectMapper = new ObjectMapper();
                session.getRemote().sendString(objectMapper.writeValueAsString(lampStatus));
            }
        }
//        while (true) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            StatusResponse statusResponse = new StatusResponse();
//            statusResponse.setType("lampStatus");
//            LampStatus lampStatus = new LampStatus();
//            Random random = new Random();
//            lampStatus.setActivePower(random.nextFloat());
//            lampStatus.setTemperature(random.nextFloat());
//            lampStatus.setApparentPower(random.nextFloat());
//            lampStatus.setBurningHour(random.nextInt());
//            lampStatus.setCurrentFlow(random.nextFloat());
//            lampStatus.setEnergyUsage(new EnergyUsage(350d, new Date()));
//            lampStatus.setInstalledDate(new Date());
//            lampStatus.setLampLevel(random.nextInt());
//            lampStatus.setLampSwitch(true);
//            lampStatus.setPowerFactor(random.nextFloat());
//            lampStatus.setVoltage(12f);
//            lampStatus.setOperationState(OperationState.LampFailure);
//            lampStatus.setNodeFailureMessage("Lamp Failure");
//            statusResponse.setObject(lampStatus);
//            ObjectMapper objectMapper = new ObjectMapper();
//            session.getRemote().sendString(objectMapper.writeValueAsString(statusResponse));
//        }
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
