package com.stee.nia.service.impl;

import com.google.common.collect.Lists;
import com.stee.nia.adaptor.Adaptor;
import com.stee.nia.model.nms.auth.AuthMessage;
import com.stee.nia.model.nms.auth.AuthResult;
import com.stee.nia.model.nms.realtime.RealtimeNmsResult;
import com.stee.nia.model.nms.realtime.RealtimeResponse;
import com.stee.nia.model.nms.realtime.RealtimeResultObject;
import com.stee.nia.model.realtime.Commands;
import com.stee.nia.model.realtime.Get;
import com.stee.nia.model.realtime.Set;
import com.stee.nia.model.scheduled.Configuration;
import com.stee.nia.repository.LampInfoRepository;
import com.stee.nia.repository.LampPointMeaningsRepository;
import com.stee.nia.repository.LuminaireRepository;
import com.stee.nia.service.IRealTimeService;
import com.stee.sel.asm.LuminaireModelConfig;
import com.stee.sel.constant.ControlMode;
import com.stee.sel.constant.OperationState;
import com.stee.sel.lcm.ConfigCommand;
import com.stee.sel.lim.LampInfo;
import com.stee.sel.lim.control.LampControl;
import com.stee.sel.lim.status.EnergyUsage;
import com.stee.sel.lim.status.LampStatus;
import com.stee.sel.nia.LampPointMeanings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
 * File Name    : RealTimeServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年10月18日 下午3:13:25
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service("realTimeServiceImpl")
public class RealTimeServiceImpl implements IRealTimeService {
    @Autowired
    LampPointMeaningsRepository repository;

    @Autowired
    LampInfoRepository lampRepo;

    @Autowired
    LuminaireRepository luminaireRepo;

    private static RestTemplate template = new RestTemplate();

    private static String token;

    private static String userName;

    private static String password;

    private static String authUri;

    private static String realTimeUri;

    private static String scheduleUri;

    public static Map<String, String> map = new HashMap<>();

    ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    @Override
    public String send(ConfigCommand cc) throws Throwable {
        String id = cc.getDeviceId();
        Commands commands = new Commands();
        List<Set> list = Lists.newArrayList();
        if (null != cc.getControlMode()) {
            if (cc.getControlMode() == 1) {
                return "Auto mode..";
            }
            LampInfo lampInfo = lampRepo.findOne(id);
            lampInfo.getLampControl().setControlMode(ControlMode.Manual);
            lampRepo.save(lampInfo);
//            Set set = new Set();
//			set.setId(id);
//			set.setMeaning("LampCommandMode");
//			set.setValue(cc.getControlMode() == 0 ? "MANUAL" : "AUTOMATIC");
//			list.add(set);
        }
        if (null != cc.getLampLevel()) {
            Set set = new Set();
            set.setId(id);
            set.setMeaning("LampLevelCommand");
            set.setValue(String.valueOf(cc.getLampLevel()));
            list.add(set);
        }
        commands.setSet(list);
        return sendRealTime(commands);
    }

    private void reloadProps() {
        String host = map.get("nms.host");
        String port = map.get("nms.port");
        String tokenR = map.get("nms.rest.token");
        String realTimeUriR = map.get("nms.rest.realtime");
        String scheduleUriR = map.get("nms.rest.scheduled");
        String authId = map.get("nms.auth.id");
        String authPassword = map.get("nms.auth.password");
        String httpAddress = "http://" + host + ":" + port;
        authUri = httpAddress + tokenR;
        realTimeUri = httpAddress + realTimeUriR;
        scheduleUri = httpAddress + scheduleUriR;
        userName = authId;
        password = authPassword;
    }

    public void getToken() {
        // 重载配置参数
        reloadProps();
        HttpHeaders headers = new HttpHeaders();
        headers.set("WebNMS", "version=\"5.2\",data_type=\"XML\"");
        headers.set("Authorization", "OAuth oauth_version=\"2.0\",oauth_grant_type=\"password\",oauth_client_id=\""
                + userName + "\",oauth_password=\"" + password + "\"");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<AuthMessage> response = template.exchange(authUri, HttpMethod.GET, entity, AuthMessage.class);
        try {
            AuthResult authResult = response.getBody().getAuthResult();
            token = authResult.getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendRealTime(Commands commands) {
        if (resourceBundle.getString("environment").equals("0")) {
            reloadProps();
        } else {
            getToken();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",
                "OAuth oauth_grant_type=\"password\",oauth_version=\"2.0\",oauth_access_token=\"" + token + "\"");
        headers.set("Content-Type", "application/xml;charset=UTF-8");

        HttpEntity<?> httpEntity = new HttpEntity<>(commands, headers);
        RealtimeNmsResult response = template.postForObject(realTimeUri, httpEntity, RealtimeNmsResult.class);

        if (response.getStatus().equals("SUCCESS")) {
            if (null != commands.getSet() && !commands.getSet().isEmpty()) {
                for (Set set : commands.getSet()) {
                    String id = set.getId();
                    String value = set.getValue();
                    LampInfo one = lampRepo.findOne(id);
                    one.getLampStatus().setLampSwitch(Integer.valueOf(value) != 0);
                    lampRepo.save(one);
                }
            }
            RealtimeResultObject resultObject = response.getResultObject();
            List<RealtimeResponse> responses = Lists.newArrayList();
            if (null != resultObject) {
                responses = resultObject.getResponses();
            }
            if (null != commands.getGet() && !commands.getGet().isEmpty()) {
                for (int i = 0; i < commands.getGet().size(); i++) {
                    String id = commands.getGet().get(i).getId();
                    if (null != responses && !responses.isEmpty()) {
                        Object value = responses.get(i).getValue();
                        Integer burningHour = (Integer) value;
                        LampInfo lampInfo = lampRepo.findOne(id);
                        lampInfo.getLampStatus().setBurningHour(burningHour);
                        lampRepo.save(lampInfo);
                    }
                }
            }
        }

//        if (response.getMessage().contains("access_token_expired")) {
//			getToken();
//			sendRealTime(commands);
//			return "access_token_expired";
//		}
        return Adaptor.beanToXml(response);
    }

    public String sendScheduled(Configuration config) {
        if (resourceBundle.getString("environment").equals("0")) {
            reloadProps();
        } else {
            getToken();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",
                "OAuth oauth_grant_type=\"password\",oauth_version=\"2.0\",oauth_access_token=\"" + token + "\"");
        headers.set("Content-Type", "application/xml;charset=UTF-8");
        HttpEntity<?> httpEntity = new HttpEntity<>(config, headers);
        RealtimeNmsResult realtimeNmsResult = template.postForObject(scheduleUri, httpEntity, RealtimeNmsResult.class);
        if (realtimeNmsResult.getStatus().equals("SUCCESS")) {
            // TODO: 2016/12/18 Asyn advice client the commission status.
        }
        // TODO: 2016/12/18 In addition of failed.Asyn advice client too.
        return null;
    }

    public void testPollingStatus() {
        Commands commands = new Commands();
        List<Get> gets = Lists.newArrayList();
        List<LampInfo> lampInfos = lampRepo.findAll();
        if (null != lampInfos && !lampInfos.isEmpty()) {
            for (LampInfo lampInfo : lampInfos) {
                String id = lampInfo.getId();
                Get get = new Get();
                get.setId(id);
                gets.add(get);
            }
        }
        commands.setGet(gets);
        sendRealTime(commands);
    }

    /**
     * 轮询状态
     *
     * @author Jerry
     */
    public void getPollingStatus() {
        // 获取Token.
        getToken();
        Commands commands = getPollingCommands();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",
                "OAuth oauth_grant_type=\"password\",oauth_version=\"2.0\",oauth_access_token=\"" + token + "\"");
        headers.set("Content-Type", "application/xml;charset=UTF-8");

        HttpEntity<?> httpEntity = new HttpEntity<>(commands, headers);
        RealtimeNmsResult response = template.postForObject(realTimeUri, httpEntity, RealtimeNmsResult.class);

        if (response.getMessage().contains("access_token_expired")) {
            getToken();
            getPollingStatus();
            return;
        }

        RealtimeResultObject resultObject = response.getResultObject();
        List<RealtimeResponse> responses = resultObject.getResponses();
        List<LampInfo> dealingWithStatus = dealingWithStatus(responses);
        updateDevices(dealingWithStatus);
    }

    private static List<Get> assembGetList = new ArrayList<>();

    private static List<String> pollingIds = new ArrayList<>();

    /**
     * 更新设备对应状态
     *
     * @param responses
     * @return
     * @author Jerry
     */
    private List<LampInfo> dealingWithStatus(List<RealtimeResponse> responses) {
        List<LampInfo> list = new ArrayList<>();
        if (!responses.isEmpty()) {
            for (int i = 0; i < responses.size(); i++) {
                String id = pollingIds.get(i);
                RealtimeResponse getResponse = responses.get(i);
                String status = getResponse.getStatus();
                Object value = getResponse.getValue();
                if (!status.equals("OK")) {
                    continue;
                }
                LampInfo findOne = lampRepo.findOne(id);
                LampStatus lampStatus = findOne.getLampStatus();
                LampControl lampControl = findOne.getLampControl();

                int j = i % assembGetList.size();
                if (j == 0) {
                    switch (i) {
                        case 0:
                            lampStatus.setCurrentFlow((Float) value);
                            break;
                        case 1:
                            if (value.equals("AUTOMATIC")) {
                                lampControl.setControlMode(ControlMode.Automatic);
                            } else {
                                lampControl.setControlMode(ControlMode.Manual);
                            }
                            break;
                        case 2:
                            lampStatus.setLampSwitch((boolean) value);
                            break;
                        case 3:
                            lampStatus.setEnergyUsage(new EnergyUsage((Double) value, new Date()));
                            break;
                        case 4:
                            if (!(boolean) value) {
                                lampStatus.setOperationState(OperationState.LampFailure);
                            }
                            break;
                        case 5:
                            lampStatus.setLampLevel((Integer) value);
                            break;
                        case 6:
                            // The same as lampLevel
                            break;
                        case 7:
                            lampStatus.setApparentPower((Float) value);
                            break;
                        case 8:
                            // The same as lampSwitch
                            break;
                        case 9:
                            // Main voltage instead.
                            // lampStatus.setVoltage((Float) value);
                            break;
                        case 10:
                            if ((boolean) value) {
                                lampStatus.setOperationState(OperationState.CommsFailure);
                            }
                            break;
                        case 11:
                            // Main voltage
                            lampStatus.setVoltage((Float) value);
                            break;
                        case 12:
                            // Motion Control
                            break;
                        case 13:
                            if ((boolean) value) {
                                lampStatus.setOperationState(OperationState.NodeFailure);
                            }
                            break;
                        case 14:
                            lampStatus.setNodeFailureMessage((String) value);
                            break;
                        case 15:
                            lampStatus.setPowerFactor((Float) value);
                            break;
                        case 16:
                            // State timeout control
                            break;
                        case 17:
                            lampStatus.setTemperature((Float) value);
                            break;
                        case 18:
                            // UnknowIdentifier
                            break;
                    }
                } else {
                    switch (j) {
                        case 1:
                            lampStatus.setCurrentFlow((Float) value);
                            break;
                        case 2:
                            if (value.equals("AUTOMATIC")) {
                                lampControl.setControlMode(ControlMode.Automatic);
                            } else {
                                lampControl.setControlMode(ControlMode.Manual);
                            }
                            break;
                        case 3:
                            lampStatus.setLampSwitch((boolean) value);
                            break;
                        case 4:
                            lampStatus.setEnergyUsage(new EnergyUsage((Double) value, new Date()));
                            break;
                        case 5:
                            if (!(boolean) value) {
                                lampStatus.setOperationState(OperationState.LampFailure);
                            }
                            break;
                        case 6:
                            lampStatus.setLampLevel((Integer) value);
                            break;
                        case 7:
                            // The same as lampLevel
                            break;
                        case 8:
                            lampStatus.setApparentPower((Float) value);
                            break;
                        case 9:
                            // The same as lampSwitch
                            break;
                        case 10:
                            // lampStatus.setVoltage((Float) value);
                            break;
                        case 11:
                            if ((boolean) value) {
                                lampStatus.setOperationState(OperationState.CommsFailure);
                            }
                            break;
                        case 12:
                            // Main Voltage
                            lampStatus.setVoltage((Float) value);
                            break;
                        case 13:
                            // Motion Control
                            break;
                        case 14:
                            if ((boolean) value) {
                                lampStatus.setOperationState(OperationState.NodeFailure);
                            }
                            break;
                        case 15:
                            lampStatus.setNodeFailureMessage((String) value);
                            break;
                        case 16:
                            lampStatus.setPowerFactor((Float) value);
                            break;
                        case 17:
                            // State timeout control
                            break;
                        case 18:
                            lampStatus.setTemperature((Float) value);
                            break;
                        case 19:
                            // UnknowIdentifier
                            break;
                    }
                }
                findOne.setLampControl(lampControl);
                findOne.setLampStatus(lampStatus);
                list.add(findOne);
            }
        }
        return list;
    }

    /**
     * 发送设备状态
     *
     * @param devices
     * @author Jerry
     */
    private void updateDevices(List<LampInfo> devices) {
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        String url = bundle.getString("lim.rest.update");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(url, devices);
    }

    /**
     * 组合LampPoint Meanings
     *
     * @param deviceId
     * @return
     * @author Jerry
     */
    private List<Get> assembGet(String deviceId) {
        List<Get> list = new ArrayList<>();
        List<LampPointMeanings> findAll = repository.findAll();
        if (!findAll.isEmpty()) {
            findAll.forEach(mean -> {
                Get get = new Get();
                get.setId(deviceId);
                get.setMeaning(mean.getMeaning());
                list.add(get);
            });
        }
        assembGetList.clear();
        assembGetList.addAll(list);
        return list;
    }

    /**
     * 获取支持轮询的设备ID集合
     *
     * @return
     * @author Jerry
     */
    private List<String> getPollingDevices() {
        List<String> deviceIds = new ArrayList<>();
        List<LampInfo> allLamp = lampRepo.findAll();
        if (!allLamp.isEmpty()) {
            allLamp.forEach(lamp -> {
                String moduleId = lamp.getModuleId();
                LuminaireModelConfig luminaire = luminaireRepo.findByModelId(moduleId);
                if (null == luminaire) {
                    return;
                }
                boolean pollingMethod = luminaire.isPollingMethod();
                if (pollingMethod) {
                    deviceIds.add(lamp.getId());
                }
            });
        }
        pollingIds.clear();
        pollingIds.addAll(deviceIds);
        return deviceIds;
    }

    /**
     * 获取轮询发送数据
     *
     * @return
     * @author Jerry
     */
    private Commands getPollingCommands() {
        Commands commands = new Commands();
        List<Get> getList = new ArrayList<>();
        List<String> pollingDevices = getPollingDevices();
        if (!pollingDevices.isEmpty()) {
            pollingDevices.forEach(id -> {
                List<Get> assembGet = assembGet(id);
                if (null == assembGet) {
                    return;
                }
                getList.addAll(assembGet);
            });
        }
        commands.setGet(getList);
        return commands;
    }
}
