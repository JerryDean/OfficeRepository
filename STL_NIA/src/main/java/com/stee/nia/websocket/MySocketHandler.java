package com.stee.nia.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stee.sel.constant.OperationState;
import com.stee.sel.lim.status.EnergyUsage;
import com.stee.sel.lim.status.LampStatus;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

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

	@OnWebSocketMessage
	public void onMessage(Session session, String message) throws IOException {
		System.out.println(message);
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setType("lampStatus");
            LampStatus lampStatus = new LampStatus();
            Random random = new Random();
            lampStatus.setActivePower(random.nextFloat());
            lampStatus.setTemperature(random.nextFloat());
            lampStatus.setApparentPower(random.nextFloat());
            lampStatus.setBurningHour(random.nextInt());
            lampStatus.setCurrentFlow(random.nextFloat());
            lampStatus.setEnergyUsage(new EnergyUsage(350d, new Date()));
            lampStatus.setInstalledDate(new Date());
            lampStatus.setLampLevel(random.nextInt());
            lampStatus.setLampSwitch(true);
            lampStatus.setPowerFactor(random.nextFloat());
            lampStatus.setVoltage(12f);
            lampStatus.setOperationState(OperationState.LampFailure);
            lampStatus.setNodeFailureMessage("Lamp Failure");
            statusResponse.setObject(lampStatus);
            ObjectMapper objectMapper = new ObjectMapper();
            session.getRemote().sendString(objectMapper.writeValueAsString(statusResponse));
        }
    }

	@OnWebSocketConnect
	public void onOpen(Session session) {
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
