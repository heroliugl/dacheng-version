package com.dacheng.mqtt;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacheng.mqtt.entity.Message;


/**
 * Created by Kai Wang on 16/8/12.
 */
/*@Service*/
public class CommandService {
    org.slf4j.Logger logger = LoggerFactory.getLogger(CommandService.class);


   /* @Autowired*/
    private MQTTUtils mqttUtils;

    public void handler(Message msg) {
        System.out.println("received:" + msg);
/*        if(null != msg){
            if (msg.getHcode() == CommandConstants.REGISTER) {
                handlerRegister(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_FUNC_TEST) {
                handlerFunctionTestAck(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_DURATION_TEST) {
                handlerDurationTestAck(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_STOP_TEST) {
                handlerStopTestAck(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_INHIBIT_MODE) {
                handlerLampInhibitModeAck(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_REST_MODE) {
                handlerLampRestModeAck(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_TERMINATE_INHIBIT_REST_MODE) {
                handlerExitModeAck(msg);
            } else if (msg.getHcode() == CommandConstants.QUERY_DEVICE) {
                handlerQueryDeviceAck(msg);
            } else if (msg.getHcode() == CommandConstants.DEVICE_ATTR_SET) {
                handlerEditDeviceAck(msg);
            } else if (msg.getHcode() == CommandConstants.A_B_LAMP) {
                int action = (int) msg.getAttr("action");
                if (action == CommandConstants.A_B_LAMP_ACTION_ON) {
                    handlerLampABOnAck(msg);
                } else if (action == CommandConstants.A_B_LAMP_ACTION_OFF) {
                    handlerLampABOffAck(msg);
                } else if (action == CommandConstants.A_B_LAMP_ACTION_FLASH_START) {
                    handlerLampABFlashAck(msg);
                } else if (action == CommandConstants.A_B_LAMP_ACTION_FLASH_STOP) {
                    handlerLampABFlashStopAck(msg);
                }
            } else if (msg.getHcode() == CommandConstants.ADD_NEW_LAMP) {
                handlerAddDeviceAck(msg);
            } else if (msg.getHcode() == CommandConstants.RE_INTIALIZE) {
                handlerReInitializeAck(msg);
            } else if (msg.getHcode() == CommandConstants.SEARCH_DEIVCE) {
                handlerSearchLampAck(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_ATTR_QUERY) {
                handlerLampAttrQueryAck(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_ATTR_SET) {
                handlerLampAttrEditAck(msg);
            } else if (msg.getHcode() == CommandConstants.VERSION_QUERY) {
                handlerVersionQuery(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_INFO_REPORT) {
                handlerLampInfoReport(msg);
                System.out.println("handlerLampInfoReport = ======== ="+new Date());
            } else if (msg.getHcode() == CommandConstants.LAMP_DETAIL_QUERY) {
                handlerLampDetail(msg);
            } else if (msg.getHcode() == CommandConstants.LAMP_TEST_STATUS_QUERY) {
                handlerTestStatusQuery(msg);
            }else if (msg.getHcode() == CommandConstants.GROUP_TIMING_TEST_SET) {
                handlerGroupTestSet(msg);
            }*/
            
           /* if(StringUtils.isNotBlank(msg.getHmac())){
            	deviceService.updateStampByMac(msg.getHmac());
            }
        	
        }*/
    }

   /* *//**
     * 测试报告
     *
     * @param msg
     *//*
    public void handlerTestStatusQuery(Message msg) {
        System.out.println("test status query " + msg);
        TestReport report = new TestReport();
        String sa = (String) msg.getAttr("TestStatus", "SA");
        String mac = msg.getHmac();
        Lamp lamp = lampService.findByMacAndSa(mac, sa);
        if (lamp == null) {
            logger.info("does not have this lamp sa:" + sa + "mac:" + mac);
            System.out.println("does not have this lamp sa:" + sa + "mac:" + mac);
            //// TODO: 16/9/8  是否发送添加灯的命令
            return;
        }
        report.setShortAddress(sa);
        report.setLampName((String) msg.getAttr("TestStatus", "name"));
        report.setLocation((String) msg.getAttr("TestStatus", "loc"));
        report.setTestTime(parseMsgDate((String)msg.getAttr("TestStatus","date")));
        report.setResult((String) msg.getAttr("TestStatus", "result"));
        report.setStatus((String) msg.getAttr("TestStatus", "status"));
        report.setMonitorId(msg.getMonitorId());
        report.setDeviceId(lamp.getDevice().getId());
        report.setBuildingId(lamp.getDevice().getUserBuilding().getId());
        report.setTestType(lamp.getLampType());
        report.setUserId(lamp.getDevice().getUserBuilding().getUserId());
        report.setLampId(lamp.getId());
        reportService.save(report);
        
    }

    private Date parseMsgDate(String date){
    	if(StringUtils.isNotBlank(date)){
    		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
    		try {
    			 Date date1 = sdf.parse(date);  
    			 return date1;
			} catch (Exception e) {
			}
    	}
        return new Date();
   }

    *//**
     * 灯详情
     *
     * @param msg
     *//*
    public void handlerLampDetail(Message msg) {
        System.out.println("lamp detail :" + msg);
        LampDetail detail = createLampDetail(msg);
        lampService.upsertLampDetail(detail);
        
    }

    private LampDetail createLampDetail(Message msg) {
        LampDetail detail = new LampDetail();
        String mac = msg.getHmac();
        if (mac == null) {
            logger.error("mac  is null");
            System.out.println("mac  is null");
        }
        String sa = msg.getSa();
        Lamp lamp = lampService.findByMacAndSa(mac, sa);
        if (lamp == null) {
            logger.error("lamp id is null");
            System.out.println("lamp id is null");
        }
        detail.setId(lamp.getId());
        detail.setEmergencyStatus((int) msg.getAttr("EmS"));
        detail.setFeatures((int) msg.getAttr("Feat"));
        detail.setOpModel((int) msg.getAttr("OpMode"));
        detail.setStatus((int) msg.getAttr("Status"));
        detail.setFaults((int) msg.getAttr("Faults"));
        LampLevel level = new LampLevel();
        level.setPhysicalMin((int) msg.getAttr("Level", "PhyMin"));
        level.setMax((int) msg.getAttr("Level", "MaxL"));
        level.setMin((int) msg.getAttr("Level", "MinL"));
        level.setSysFail((int) msg.getAttr("Level", "SFL"));
        level.setFadeTime((int) msg.getAttr("Level", "FTS"));
        level.setFadeRate((int) msg.getAttr("Level", "FRSS"));
        level.setPowerOn((int) msg.getAttr("Level", "POL"));
        detail.setLampLevel(level);

        LampContinued cond = new LampContinued();
        cond.setEmergencyTime((int) msg.getAttr("Contd", "LET"));
        cond.setBatteryChargingState((int) msg.getAttr("Contd", "BCS"));
        cond.setDurationTestResult((int) msg.getAttr("Contd", "DTR"));
        cond.setBurnInEmergence((int) msg.getAttr("Contd", "LBHIE"));
        cond.setBurnTotal((int) msg.getAttr("Contd", "LBHT"));
        cond.setRateDuration((int) msg.getAttr("Contd", "RD"));
        detail.setLampContinued(cond);

        TestTiming testTiming = new TestTiming();
        testTiming.setProlongTime((int) msg.getAttr("TestT", "ProLT"));
        testTiming.setNextFuncTest((int) msg.getAttr("TestT", "NFT"));
        testTiming.setNextDurationTest((int) msg.getAttr("TestT", "NDT"));
        testTiming.setFuncTestInterval((int) msg.getAttr("TestT", "FTI"));
        testTiming.setDurationTestInterval((int) msg.getAttr("TestT", "DTI"));
        testTiming.setTestExeTimeout((int) msg.getAttr("TestT", "TET"));
        detail.setTestTiming(testTiming);

        return detail;
    }

    *//**
     * handlerLampInfoReport
     *
     * @param msg
     *//*
    public void handlerLampInfoReport(Message msg) {
        System.out.println("handlerLampInfoReport :" + msg);
        
        Message resp = createResponseMsg(msg);
        if (msg.getHack() == CommandConstants.MSG_ACK_YES) {
            sendMsg(resp, true);
        }
        
        String mac = msg.getHmac();
        boolean flag = false;
       
        List<Map> infos = (List) msg.getAttr("Info");
        Device device = deviceService.findByMac(mac);
        try {
            if (null != device && infos != null
            		&& infos.size() > 0) {
                for (int i = 0; i < infos.size(); i++) {
                    Map info = infos.get(i);
                    Lamp lamp = new Lamp();
                    lamp.setDevice(device);
                    Integer fail=(Integer) info.get("fail");
                    Integer on=(Integer) info.get("on");
                    String sa = info.get("SA").toString();
                    if(null != on && StringUtils.isNotBlank(sa)){ 
                    	Lamp _lampSa = lampService.findByDeviceIdAndSa(device.getId(), sa);
                    	if(on == 0){
                    		if(null != _lampSa){
                    			// Show that the short address without lamp or a lamp has been removed, delete this lamp from the database
                        		lampService.deleteById(_lampSa.getId());
                    		}
                    	}else{ 
                    		// Show that the short address has a lamp, update this lamp from the database
                    		lamp.setShortAddress(sa);
                    		lamp.setLampType(info.get("type").toString().trim());
                            lamp.setOnline(on);
                            lamp.setEmerType(1);  // default value
                            lamp.setFail(fail);
                            lamp.setGroup((Integer) info.get("gp"));
                            lamp.setStatus(CommandConstants.getLampStatusString(fail));
                            lamp.setLoc(info.get("loc").toString().trim());
                            lamp.setName(info.get("name").toString().trim());
                            if(null != _lampSa){
                            	lampService.updateByDeviceAndSa(lamp);
                            }else{
                            	lamp.setFloor(device.getFloor());  // new lamp floor same as semm-2
                                lampService.save(lamp);
                            }
                    	}
                    }
                }
                notifyLampFailure(device,infos);
            }
        } catch (Exception e) {
            resp.setResult(CommandConstants.RESULT_FAILED);
            if (msg.getHack() == CommandConstants.MSG_ACK_YES) {
                sendMsg(resp, true);
            }
            e.printStackTrace();
        }
       
    }

    *//***
     * 处理report info 里的楼层失败和紧急个数
     * @param device
     * @param infos
     *//*
    private void lampFloorReport(Device device ,List<Map> infos){
        Optional.ofNullable(infos).orElseGet(Collections::emptyList).forEach(info ->{
            String floor=(String)info.get("floor");
            int failedNum= (int) info.get("FailNo");
            int emgNo = (int) info.get("EmgNo");
            DeviceFloorNumInfo numInfo=new DeviceFloorNumInfo();
            numInfo.setDeviceId(device.getId());
            numInfo.setFloor(floor);
            numInfo.setFailedNum(failedNum);
            numInfo.setEmgNum(emgNo);
            deviceService.upsertDeivceFloorNumInfo(numInfo);
        });
    }

    *//**
     * 每次有failure状态的灯 发邮件
     * @param device
     * @param infos
     *//*
    private void notifyLampFailure(Device device ,List<Map> infos){
        try {
            notifyService.sendLampFailureEmail(device,infos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handlerVersionQuery(Message msg) {
        System.out.println("version query :" + msg);
        if (msg.getHobj() == CommandConstants.MSG_OBJ_LAMP) {
            handlerLampVersionQuery(msg);
        } else {
            handlerDeviceVersionQuery(msg);
        }

    }

    *//**
     * 推荐或者查询版本号推送
     *
     * @param msg
     *//*
    public void handlerDeviceVersionQuery(Message msg) {
        System.out.println("device version query :" + msg);
        Device device = deviceService.findByMac(msg.getHmac());
        if(null != device){
        	DeviceVersion deviceVersion = new DeviceVersion();
        	deviceVersion.setDeviceId(device.getId());
    		// deviceVersion.setSerial((String) msg.getAttr("Serial"));
            deviceVersion.setSoftVer((String) msg.getAttr("version","SoftVer"));
            deviceVersion.setPcbVer((String) msg.getAttr("version","PcbVer"));
            deviceVersion.setJsonVer((String) msg.getAttr("version","JsonVer"));
            // deviceVersion.setDaliVer((String) msg.getAttr("DaliVer"));
            deviceService.upsertDeviceVersion(deviceVersion);
        }
        
        if (msg.getTagId() != null) {
            Request<?> request = commandCacheService.getRequest(msg.getTagId());
            if(null != request){
            	request.setStatus(msg.getResult());
            }
            
        }
        
    }

    public void handlerLampVersionQuery(Message msg) {
        System.out.println("lampversion query :" + msg);
        Device device = deviceService.findByMac(msg.getHmac());
        if(null != device){
        	String sa = (String) msg.getAttr("SA");
        	 Lamp lamp = lampService.findByDeviceIdAndSa(device.getId(), sa);
        	 if(null != lamp){
        		 LampVersion lampVersion = new LampVersion();
        		 lampVersion.setLampId(lamp.getId());
        		 lampVersion.setSerial((String) msg.getAttr("version","Serial"));
        		 lampVersion.setSoftVer((String) msg.getAttr("version","SoftVer"));
        		 lampVersion.setPcbVer((String) msg.getAttr("version","PcbVer"));
        		// lampVersion.setJsonVer((String) msg.getAttr("JsonVer"));
        		 lampVersion.setDaliVer((String) msg.getAttr("version","DaliVer"));
        		 lampService.upsertLampVersion(lampVersion);
        	 }
        }
        if (msg.getTagId() != null) {
            Request<?> request = commandCacheService.getRequest(msg.getTagId());
            if(null != request){
            	request.setStatus(msg.getResult());
            }
        }
    }

    public void handlerLampAttrEditAck(Message msg) {
        System.out.println(System.currentTimeMillis() + ":edit attr query:" + msg);
        String tagId = msg.getTagId();
        Request<Lamp> request = commandCacheService.getRequest(tagId);
        //todo 如果超时收到消息呢?
        if (request == null) {
            System.out.println("message is out of time:" + tagId);
        } else {
            request.setStatus(msg.getResult());
            if (msg.getResult() == CommandConstants.RESULT_SUCCESS) {
                System.out.println(request.getData());
                Lamp lamp= request.getData();
                if(null != lamp){
                	lampService.update(lamp);
                }
                
            } else {
                System.out.println("request failed:" + request.toString());
            }
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerLampAttrQueryAck(Message msg) {
        System.out.println("lamp attr query:" + msg);
        //// TODO: 16/9/8
        String mac = msg.getHmac();
        String sa = (String) msg.getAttr("LampAttr", "SA");
        Lamp lamp = lampService.findByMacAndSa(mac, sa);
        if (lamp == null) {
            lamp = new Lamp();
            Device device = deviceService.findByMac(mac);
            if (device == null) {
                // TODO: 16/9/10
                System.out.println("can not find device");
            }
        }
        lamp.setGroup((int) msg.getAttr("LampAttr", "group"));
        lamp.setLoc((String) msg.getAttr("LampAttr", "loc"));
        lamp.setName((String) msg.getAttr("LampAttr", "name"));
        lamp.setStatus((String) msg.getAttr("LampAttr", "status"));
        lampService.upsert(lamp);
        
    }

    public void handlerSearchLampAck(Message msg) {
        System.out.println("search lamp:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerReInitializeAck(Message msg) {
        System.out.println("re initialize:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if (request != null) {
            request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
            // TODO: 16/9/10 ttl for add device
        }
        String mac = msg.getHmac();
        if (mac == null) {
            logger.error("mac is null");
        }
        Device device = deviceService.findByMac(mac);
        if (device == null) {
            logger.error("device is null");
        }
        if (msg.getResult() == CommandConstants.SEARCHING_RESULT) {
            // 添加设备
            List<Lamp> lamps = msg.getLampAttrList();
            lamps.forEach(lamp -> {
                lamp.setDevice(device);
                lampService.upsert(lamp);
            });
        }
        
    }

    *//**
     * 添加设备
     *
     * @param msg
     *//*
    public void handlerAddDeviceAck(Message msg) {
        System.out.println("add new device:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if (request != null) {
            request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
            // TODO: 16/9/10 ttl for add device
        }
        String mac = msg.getHmac();
        if (mac == null) {
            logger.error("mac is null");
        }
        Device device = deviceService.findByMac(mac);
        if (device == null) {
            logger.error("device is null");
        }

        if (msg.getResult() == CommandConstants.SEARCHING_RESULT) {
            // 添加设备
            List<Lamp> lamps = msg.getLampAttrList();
            lamps.forEach(lamp -> {
                lamp.setDevice(device);
                lampService.upsert(lamp);
            });

        }
        

    }

    public void handlerLampABOnAck(Message msg) {
        System.out.println("lamp ab on:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerLampABOffAck(Message msg) {
        System.out.println("lamp ab off:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerLampABFlashAck(Message msg) {
        System.out.println("lamp ab flash:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        //todo no request
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerLampABFlashStopAck(Message msg) {
        System.out.println("lamp ab flash stop:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        //todo no request
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerEditDeviceAck(Message msg) {
        System.out.println("device attr set:" + msg);
        String tagId = msg.getTagId();
        Request<Device> request = commandCacheService.getRequest(tagId);
        //todo 如果超时收到消息呢?
        if (request == null) {
            System.out.println("message is out of time:" + tagId);
        } else {
            request.setStatus(msg.getResult());
            if (msg.getResult() == CommandConstants.RESULT_SUCCESS) {
                System.out.println(request.getData());
                Device device = request.getData();
                device.setUpdateTime(new Date());
                deviceService.update(device);
            } else {
                System.out.println("request failed:" + request.toString());
            }
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerQueryDeviceAck(Message msg) {
        System.out.println("handlerQueryDeviceAck:" + msg);
        if (msg.getResult() == 0) {
            Device device = createDevice(msg);
            System.out.println("device mac" + device.getMac());
            Device _device = deviceService.findByMac(device.getMac());
            if (null != _device && StringUtils.isNotBlank(_device.getMac())) {
            	device.setId(_device.getId());
            	deviceService.update(device);
            }else{
            	deviceService.save(device);
            }
        } else {
            //查询失败后处理  暂时无
            System.out.println(" msg result failed" + msg.getResult());
            logger.info(" msg result failed");
        }
        

    }

    public void handlerRegister(Message msg) {
        Message rep = createResponseMsg(msg);
        try {
//            CRC32 crc = new CRC32();
//            crc.update(rep.toJson().getBytes());
//            rep.getCrc(crc.getValue());

            //check if device exist or no building
            Device device = createDevice(msg);
            System.out.println("device mac" + device.getMac());
            if (!deviceService.existByMac(device.getMac())) {
                deviceService.save(device);
            }
            mqttUtils.publishMessage(Constant.DEV_PRE + msg.getHmac(), rep.toJson());
            System.out.println("public to :" + Constant.DEV_PRE + msg.getHmac());
            System.out.println(rep.toJson());
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
    public void handlerGroupTestSet(Message msg) {
        System.out.println("group test set:" + msg);
        String tagId = msg.getTagId();
        if(msg.getHtype() == 3){  // set 上报
        	handlerReportedGroupTestSet(msg);
        }else{
        	 Request<Void> request = commandCacheService.getRequest(tagId);
             if(null != request){
             	request.setStatus(msg.getResult());
                 commandCacheService.putRequest(request);
             }
        }
    }
    
    public void handlerReportedGroupTestSet(Message msg) {
        System.out.println("group test set:" + msg);
        String tagId = msg.getTagId();
        Device device = deviceService.findByMac(msg.getHmac());
        if(null != device && null != device.getMac()){
        	GroupTestTiming ftDt = new GroupTestTiming();
        	ftDt.setDeviceId(device.getId());
        	ftDt.setFtSet((Integer) msg.getAttr("FTSet"));
        	ftDt.setdTSet((Integer) msg.getAttr("DTSet"));
        	groupTimingSetService.upsertFtDtSet(ftDt);
        	
            List<Map> infos = (List) msg.getAttr("GpSet");
            try {
                if (infos != null && infos.size() > 0) {
                    for (int i = 0; i < infos.size(); i++) {
                        Map info = infos.get(i);
                        GroupTimingSet set = new GroupTimingSet();
                        set.setDeviceId(device.getId());
                        set.setGroup((Integer) info.get("Gp"));
                        set.setMonth((Integer) info.get("month"));
                        set.setDay((Integer) info.get("day"));
                        set.setWeek((Integer) info.get("week"));
                        set.setHour((Integer) info.get("hour"));
                        set.setMin((Integer) info.get("min"));
                        groupTimingSetService.upsertTimingSet(set);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private Device createDevice(Message msg) {
        Device device = new Device();
        device.setIp("0.0.0.0");
        device.setEmergencyNum(0);
        device.setFailNum(0);
        device.setMac(msg.getHmac());
        device.setMonitorId(msg.getMonitorId());
        device.setMonitorType(msg.getMonitorType());
        device.setStatus(CommandConstants.STATUS_ONLINE);
//        device.setUserBuilding(null); //todo
        device.setFloor(msg.getFloor());
        device.setUpdateTime(new Date());
        return device;
    }

    public void handlerFunctionTestAck(Message msg) {
        System.out.println("function test ack:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        
    }

    public void handlerDurationTestAck(Message msg) {
        System.out.println("duration test ack:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        

    }

    public void handlerStopTestAck(Message msg) {
        System.out.println("stop test ack:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        

    }


    public void handlerLampInhibitModeAck(Message msg) {
        System.out.println("inhibit ack:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	 request.setStatus(msg.getResult());
             commandCacheService.putRequest(request);
        }
        
    }

    public void handlerLampRestModeAck(Message msg) {
        System.out.println("rest ack:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
        

    }

    public void handlerExitModeAck(Message msg) {
        System.out.println("exit ack:" + msg);
        String tagId = msg.getTagId();
        Request<Void> request = commandCacheService.getRequest(tagId);
        if(null != request){
        	request.setStatus(msg.getResult());
            commandCacheService.putRequest(request);
        }
    }

    public void sendMsg(Message msg, boolean onMac) {
        try {
            String address = onMac ? Constant.DEV_PRE + msg.getHmac() : Constant.DEV_PRE;
            System.out.println(System.currentTimeMillis() + ":send msg:" + msg.toJson());
            System.out.println("address:" + address);
            mqttUtils.publishMessage(address, msg.toJson());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void sendMaintenanceMsg(String command, Lamp lamp, String tagId) {
        switch (command) {
            case CommandConstants.STR_LAMP_FUNC_TEST:
                System.out.println("---- func test");
                sendFunctionTest(lamp, tagId);
                break;
            case CommandConstants.STR_LAMP_DURATION_TEST:
                System.out.println("---- duration test");
                sendDurationTest(lamp, tagId);
                break;
            case CommandConstants.STR_LAMP_STOP_TEST:
                System.out.println("---- stop test");
                sendStopTest(lamp, tagId);
                break;
            case CommandConstants.STR_LAMP_INHIBIT_MODE:
                System.out.println("---- inhibit test");
                sendInhibitMode(lamp, tagId);
                break;
            case CommandConstants.STR_LAMP_REST_MODE:
                System.out.println("---- reset test");
                sendRestMode(lamp, tagId);
                break;
            case CommandConstants.STR_TERMINATE_INHIBIT_REST_MODE:
                System.out.println("---- exit test");
                sendExitMode(lamp, tagId);
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }


    *//**
     * 发送function test 命令
     *
     * @param lamp
     *//*
    public void sendFunctionTest(Lamp lamp, String tagId) {
        Message msg = createMaintenanceMsg(lamp.getDevice().getMac(), CommandConstants.LAMP_FUNC_TEST, lamp.getShortAddress(), tagId);//
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }


    *//**
     * 发送duration test 命令
     *
     * @param lamp
     *//*
    public void sendDurationTest(Lamp lamp, String tagId) {
        Message msg = createMaintenanceMsg(lamp.getDevice().getMac(), CommandConstants.LAMP_DURATION_TEST, lamp.getShortAddress(), tagId);//
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }

    *//**
     * 发送stop test 命令
     *
     * @param lamp
     *//*
    public void sendStopTest(Lamp lamp, String tagId) {
        Message msg = createMaintenanceMsg(lamp.getDevice().getMac(), CommandConstants.LAMP_STOP_TEST, lamp.getShortAddress(), tagId);//
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }

    *//**
     * 发送Inhibit 命令
     *
     * @param lamp
     *//*
    public void sendInhibitMode(Lamp lamp, String tagId) {
        Message msg = createMaintenanceMsg(lamp.getDevice().getMac(), CommandConstants.LAMP_INHIBIT_MODE, lamp.getShortAddress(), tagId);//
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }

    *//**
     * 发送Rest Model 命令
     *
     * @param lamp
     *//*
    public void sendRestMode(Lamp lamp, String tagId) {
        Message msg = createMaintenanceMsg(lamp.getDevice().getMac(), CommandConstants.LAMP_REST_MODE, lamp.getShortAddress(), tagId);//
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }

    *//**
     * 发送Terminate Inhibit/Rest Mode 命令
     *
     * @param lamp
     *//*
    public void sendExitMode(Lamp lamp, String tagId) {
        Message msg = createMaintenanceMsg(lamp.getDevice().getMac(), CommandConstants.LAMP_TERMINATE_INHIBIT_REST_MODE, lamp.getShortAddress(), tagId);//
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }

    public void sendQueryDevice(Device device, String tagId) {
        Message msg = new Message();
        msg.setHmac(Optional.ofNullable(device.getMac()).orElse(CommandConstants.BROADCAST));
        msg.setHobj(CommandConstants.MSG_OBJ_SEMM);
        msg.setHcode(CommandConstants.QUERY_DEVICE);
        msg.setHtype(CommandConstants.MSG_TYPE_QUERY);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setMonitorType(device.getMonitorType());  //todo 确认
        msg.setMonitorId(device.getMonitorId());
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, device));
    }

    public void sendEditDevice(Device device, String tagId) {
        if (device.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }
        Message msg = new Message();
        msg.setHmac(device.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_SEMM);
        msg.setHcode(CommandConstants.DEVICE_ATTR_SET);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setMonitorType(device.getMonitorType());
        msg.setMonitorId(device.getMonitorId());
        msg.setAttr("floor", device.getFloor());
        if (device.getUserBuilding() != null) {
            msg.setAttr("loc", device.getUserBuilding().getAddress());
        }
        msg.setAttr("building", null);  //todo building 暂时没有name
        msg.setAttr("loc", null);  //todo loc 暂时没有name
        msg.setAttr("user", null);  //todo user 暂时没有name
        msg.setTagId(tagId);
        commandCacheService.putRequest(new Request<>(tagId, device));
        sendMsg(msg, true);
    }


    *//**
     * a b lamp off
     *
     * @param device
     * @param group  use commandconstants.LAMP_GROUP_A commandconstants.LAMP_GROUP_B
     * @param tagId
     *//*
    public void sendLampABOff(Device device, String group, String tagId) {
        Message msg = createABLampMsg(device, CommandConstants.A_B_LAMP_ACTION_OFF, group, tagId);
        commandCacheService.putRequest(new Request<>(tagId, device));
        sendMsg(msg, true);

    }

    *//**
     * a b lamp on
     *
     * @param device
     * @param group  use commandconstants.LAMP_GROUP_A commandconstants.LAMP_GROUP_B
     * @param tagId
     *//*
    public void sendLampABOn(Device device, String group, String tagId) {
        Message msg = createABLampMsg(device, CommandConstants.A_B_LAMP_ACTION_ON, group, tagId);
        commandCacheService.putRequest(new Request<>(tagId, device));
        sendMsg(msg, true);

    }

    *//**
     * a b lamp flash start
     *
     * @param device
     * @param group  use commandconstants.LAMP_GROUP_A commandconstants.LAMP_GROUP_B
     * @param tagId
     *//*
    public void sendLampABFlashStart(Device device, String group, String tagId) {
        Message msg = createABLampMsg(device, CommandConstants.A_B_LAMP_ACTION_FLASH_START, group, tagId);
        commandCacheService.putRequest(new Request<>(tagId, device));
        sendMsg(msg, true);
    }

    *//**
     * a b lamp flash stop
     *
     * @param device
     * @param group  use commandconstants.LAMP_GROUP_A commandconstants.LAMP_GROUP_B
     * @param tagId
     *//*
    public void sendLampABFlashStop(Device device, String group, String tagId) {
        Message msg = createABLampMsg(device, CommandConstants.A_B_LAMP_ACTION_FLASH_STOP, group, tagId);
        commandCacheService.putRequest(new Request<>(tagId, device));
        sendMsg(msg, true);
    }


    *//**
     * 添加 灯   这里感觉不是太对
     *
     * @param device
     * @param tagId
     *//*
    public void sendAddLamp(Device device, String tagId) {
        if (device.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }
        Message msg = new Message();
        msg.setHmac(device.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.ADD_NEW_LAMP);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setSa("255"); //todo
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, device));
    }

    public void sendReInitialize(Device device, String tagId) {
        if (device.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }
        Message msg = new Message();
        msg.setHmac(device.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP); //todo 可能有问题
        msg.setHcode(CommandConstants.RE_INTIALIZE);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, device));
    }


    public void sendSearchLamp(Device device, String tagId) {
        if (device.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(device.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP); //todo 可能有问题
        msg.setHcode(CommandConstants.SEARCH_DEIVCE);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, device));
    }

    public void sendLampAttrQuery(Lamp lamp, String tagId) {
        if (lamp.getDevice().getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(lamp.getDevice().getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.LAMP_ATTR_QUERY);
        msg.setHtype(CommandConstants.MSG_TYPE_QUERY);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setSa(lamp.getShortAddress());
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }

    public void sendLampAttrSet(String oldSa,Lamp lamp, String tagId) {
        if (lamp.getDevice().getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(lamp.getDevice().getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.LAMP_ATTR_SET);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setAttr("SA", oldSa);  // OldSa
        Map<String, Object> lampAttr = new HashMap<>();
        lampAttr.put("SA", lamp.getShortAddress());
        lampAttr.put("name", lamp.getName());
        lampAttr.put("loc", lamp.getLoc()); // todo loc
        lampAttr.put("group", lamp.getGroup());
        lampAttr.put("status", null);
       // lampAttr.put("floor", lamp.getFloor());
        msg.setAttr("LampAttr", lampAttr);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
        sendMsg(msg, true);

    }


    public void sendLampVersionQuery(Lamp lamp, String tagId) {
        if (lamp.getDevice().getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(lamp.getDevice().getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.VERSION_QUERY);
        msg.setHtype(CommandConstants.MSG_TYPE_QUERY);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setSa(lamp.getShortAddress());
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, lamp));
    }

    public void sendDeviceVersionQuery(Device device, String tagId) {
        if (device.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(device.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_SEMM);
        msg.setHcode(CommandConstants.VERSION_QUERY);
        msg.setHtype(CommandConstants.MSG_TYPE_QUERY);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setSa(null);
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, device));
    }

    public void sendLampDetailQuery(Lamp lamp, String tagId) {
        if (lamp.getDevice().getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(lamp.getDevice().getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.LAMP_DETAIL_QUERY);
        msg.setHtype(CommandConstants.MSG_TYPE_QUERY);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setSa(lamp.getShortAddress());
        msg.setAttr("Feat", 0);
        msg.setAttr("Status", 0);
        msg.setAttr("TestT", 0);
        msg.setAttr("Level", 0);
        msg.setAttr("OpMode", 0);
        msg.setAttr("Contd", 0);
        msg.setAttr("Ems", 0);
        msg.setAttr("Faults", 0);
        msg.setTagId(tagId);
//        msg.setMonitorId(lamp.getDevice().getMonitorId());
        sendMsg(msg, true);
    }

    public void sendLampListSet(List<Lamp> lamps, String tagId) {
        if (lamps == null || lamps.size() == 0) {
            throw new IllegalArgumentException("lamps can not be null");
        }
        ;
        Device device = lamps.get(0).getDevice();
        if (device.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(device.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.LAMP_LOCATION_SET);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        List<Map> locSet = lamps.stream().map(lamp -> {
            Map<String, Object> t = new HashMap<>();
            t.put("SA", lamp.getShortAddress());
            t.put("loc", lamp.getLoc());
            t.put("name", lamp.getName());
            t.put("group", lamp.getGroup());
            return t;
        }).collect(Collectors.toList());
        msg.setAttr("LocSet", locSet);
        sendMsg(msg, true);

    }

    public void sendTimeSet(TimeSet timeSet, String tagId) {
        if (timeSet.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(timeSet.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.TIME_SETTING);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        Map<String, Object> timeSetPram = new HashMap<>();
        timeSetPram.put("year", timeSet.getYear());
        timeSetPram.put("month", timeSet.getMonth());
        timeSetPram.put("day", timeSet.getDay()); // todo loc
        timeSetPram.put("week", timeSet.getWeek());
        timeSetPram.put("hour", timeSet.getHour());
        timeSetPram.put("min", timeSet.getMin());
        timeSetPram.put("sec", timeSet.getSec());
        msg.setAttr("TimeSet", timeSetPram);
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, null));
    }

    public void sendGroupTimingTestSet(GroupTestTiming testTimng, String tagId) {
        if (testTimng.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }

        Message msg = new Message();
        msg.setHmac(testTimng.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.GROUP_TIMING_TEST_SET);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setAttr("FTSet", testTimng.getFtValue());
        msg.setAttr("DTSet", testTimng.getDtValue());
        List<Map> GpSet = testTimng.getList().stream().map(group -> {
            Map<String, Object> t = new HashMap<>();
            t.put("Gp", group.getGroup());
            t.put("month", group.getMonth());
            t.put("day", group.getDay());
            t.put("week", group.getWeek());
            t.put("hour", group.getHour());
            t.put("min", group.getMin());
            return t;
        }).collect(Collectors.toList());
        msg.setAttr("GpSet", GpSet);
        sendMsg(msg, true);
        commandCacheService.putRequest(new Request<>(tagId, null));
    }

    *//**
     * 根据消息生成需要回复的
     * 未完成,根据情况修改
     *
     * @param msg
     * @return
     *//*
    public Message createResponseMsg(Message msg) {
        System.out.println(msg.toString());
        Message rep = new Message();
        rep.setHmac(msg.getHmac());
        rep.setHobj((msg.getHobj()));
        rep.setHcode(msg.getHcode());
        rep.setHdir(CommandConstants.MSG_DIR_RESPONSE);
        rep.setHtype(msg.getHtype());
        rep.setHack(0);
        rep.setResult(0);
        rep.setTagId(msg.getTagId());
//        rep.setCrc(0);
        rep.setTtl(msg.getTtl());
        return rep;
    }

    private Message createABLampMsg(Device device, int action, String group, String tagId) {
        if (device.getMac() == null) {
            throw new IllegalArgumentException("mac can not be null");
        }
        Message msg = new Message();
        msg.setHmac(device.getMac());
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(CommandConstants.A_B_LAMP);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setTagId(tagId);
        msg.setAttr("action", action);
        msg.setSa(group);
        return msg;
    }

    private Message createMaintenanceMsg(String mac, int code, String sa, String tagId) {
        Message msg = new Message();
        msg.setHmac(mac);
        msg.setHobj(CommandConstants.MSG_OBJ_LAMP);
        msg.setHcode(code);
        msg.setHdir(CommandConstants.MSG_DIR_REQUEST);
        msg.setHtype(CommandConstants.MSG_TYPE_SET);
        msg.setHack(CommandConstants.MSG_ACK_YES);
        msg.setResult(CommandConstants.RESULT_SUCCESS);
        msg.setTagId(tagId);
        msg.setSa(sa);
        return msg;
    }*/
}
