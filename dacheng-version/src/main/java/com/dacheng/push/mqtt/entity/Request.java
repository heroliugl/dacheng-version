package com.dacheng.push.mqtt.entity;

/**
 * Created by WangKai on 16/8/31.
 */
public class Request<T> {
    private String tagId;
    private T data;
    private int status=-1;  //-1为初使状态 发送 未接收 ,接收后 状态使用ack的result

    public Request(String tagId, T data) {
        this.tagId = tagId;
        this.data = data;
    }

    public Request() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTagId() {

        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "tagId='" + tagId + '\'' +
                ", data=" + data +
                ", status=" + status +
                '}';
    }
}
