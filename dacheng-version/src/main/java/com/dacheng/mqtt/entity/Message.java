package com.dacheng.mqtt.entity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Created by Kai Wang on 16/8/12.
 * 封装协议消息
 */
public class Message {
    private Map<String, Object> body = new HashMap<String, Object>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public Message(String json) throws IOException {
        body = objectMapper.readValue(json,Map.class);
    }

    public Message(){
        body.put("header", new HashMap<String, Object>());
        body.put("crc",0);
        body.put("ttl",0);
    }

    public String toJson() throws JsonProcessingException {
        return objectMapper.writeValueAsString(body);
    }

    @Override
    public String toString(){
        try {
            return toJson();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public Map<String, Object> getHeader() {
        return (Map<String, Object>) body.get("header");
    }

    public String getHmac(){
        return (String) getHeader().get("mac");
    }

    public int getHobj(){
        return (int) getHeader().get("obj");
    }

    public int getHcode(){
        return (int) getHeader().get("code");
    }

    public int getHtype(){
        return (int) getHeader().get("type");
    }

    public int getHdir(){
        return (int) getHeader().get("dir");
    }

    public int getHack(){
        return (int) getHeader().get("ack");
    }

    public int getCrc(){
        return (int) body.get("crc");
    }

    public int getTtl(){
        return (int) body.get("ttl");
    }

    public int getResult(){
        return (int) body.get("result");
    }

    public String getSa(){
        return (String) body.get("SA");
    }

    public Map<String,Object> getTag(){
        return (Map<String,Object>)body.get("tag");
    }

    public String getTagId(){
//        return (String) ((Map<String,Object>)body.get("tag")).get("id");
        Map<String,Object> tag=(Map<String,Object>)body.get("tag");
        if(tag ==null){
            return null;
        }else{
            return (String)tag.get("id");
        }

    }

    public void setHmac(String mac){
        getHeader().put("mac",mac);
    }

    public void setHobj(int obj){
        getHeader().put("obj",obj);
    }

    public void setHtype(int type){
        getHeader().put("type",type);
    }

    public void setHcode(int code){
        getHeader().put("code",code);
    }

    public void setHack(int ack){
        getHeader().put("ack",ack);
    }

    public void setHdir(int dir){
        getHeader().put("dir",dir);
    }

    public void setResult(int result){
        body.put("result",result);
    }

    public void setCrc(int crc){
        body.put("crc",crc);
    }

    public void setTtl(int ttl){
        body.put("ttl",ttl);
    }

    public void setTagId(String tagId){
        Map<String,Object> tag=(Map<String,Object>)body.get("tag");
        if(tag ==null){
            tag = new HashMap<>();
        }
        tag.put("id",tagId);
        body.put("tag",tag);
    }

    public void setTag(Map<String,Object> tag){
        body.put("tag",tag);
    }

    public void setSa(String sa){
        body.put("SA",sa);
    }

    public String getMonitorId(){
        return (String)body.get("ID");
    }

    public void setMonitorId(String monitorId){
        body.put("ID",monitorId);
    }

    public String getFloor(){
        return (String)body.get("floor");
    }

    public String getMonitorType(){
        return (String)body.get("DT");
    }

    public void setMonitorType(String type){
        body.put("DT",type);
    }

    public Object getAttr(String key){
        return body.get(key);
    }

    public Object getAttr(String key,String secondKey){
        Map<String,Object> first= (Map<String, Object>) body.get(key);
        if(first ==null){
            return null;
        }else {
            return first.get(secondKey);
        }
    }

    public void setAttr(String key,Object value){
        body.put(key,value);
    }

/*    public List<Lamp> getLampAttrList(){
        List<Map> lamps = (List) getAttr("LampAttr");
        if(lamps == null){
            return null;
        }
        return lamps.stream().map(map -> {
                    Lamp lamp = new Lamp();
                    lamp.setShortAddress((String) map.get("SA"));
                    lamp.setGroup((int)  map.get("group"));
                    lamp.setLoc((String) map.get("loc"));
                    lamp.setName((String) map.get( "name"));
                    lamp.setStatus((String) map.get("status"));
                    return lamp;
                }
        ).collect(Collectors.toList());
    }

    public String getLampSaByLampStart(int index){
        Integer start= (Integer) this.getAttr("LampStart");
        if(start==null){
            throw new IllegalArgumentException("LampStart can not be null");
        }
        int lampIndex=start+index;
        if(lampIndex>127 || lampIndex<0){
            throw new IllegalArgumentException("lamp index should not less than 0 and great than 127");
        }
        String prefix="A";
        if (lampIndex>=64){
            prefix="B";
            lampIndex= lampIndex -64;
        }

        String lampIndexStr=lampIndex <=9? "0"+lampIndex:String.valueOf(lampIndex);
        return prefix+lampIndexStr;
    }*/
}
