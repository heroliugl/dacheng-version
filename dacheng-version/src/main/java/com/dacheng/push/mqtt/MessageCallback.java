package com.dacheng.push.mqtt;

/**
 * callback interface for MQTT data receiver
 * @author Hunter
 *
 */
public interface MessageCallback {
      void onDataReceive(String data);
}
