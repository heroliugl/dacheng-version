package com.dacheng.mqtt;

import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.*;

import com.dacheng.mqtt.service.MqttCallBackService;

import java.net.URISyntaxException;
import java.util.LinkedList;


/**
 * Handle MQTT connect, subscribe and publish
 *
 * @author Hunter
 */
public class MQTTUtils implements Listener, Callback<Void> {
    private String host;
    private int port;
    private String user;
    private String password;
    private String subscribe;
    MQTT mqtt = new MQTT();
    MessageCallback messageCallback;
    CallbackConnection connection;
    FutureConnection futureConnection;
    final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
    private boolean hasConnected = false;
    private static MQTTUtils instance;

    private MqttCallBackService mqttCallBackService;

    private MQTTUtils(String host, int port, String user, String password, String subscribe) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.subscribe = subscribe;
    }

    /**
     * instance mqtt
     *
     * @return
     */
    public static MQTTUtils getInstance(String host, int port, String user, String password, String subscribe) {
        if (instance == null) {
            instance = new MQTTUtils(host, port, user, password, subscribe);
            instance.init();
        }

        return instance;
    }

    public void init() {
        try {
            mqtt.setHost(this.host, this.port);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mqtt.setUserName(this.user);
        mqtt.setPassword(this.password);
        //mqtt.setSslContext(sslContext);
    }

    public void setMessageCallback(MessageCallback messageCallback) {
        this.messageCallback = messageCallback;
    }

    /**
     * connect the MQTT server and set callback of connect status
     */
    public void startListener() {
        connection = mqtt.callbackConnection();
        connection.listener(this);
        connection.connect(this);

        futureConnection = mqtt.futureConnection();

    }

    /**
     * disconnect the connection
     */
    public void disconnect() {
        if (futureConnection != null) {
            futureConnection.disconnect();
        }

        if (connection != null) {
            connection.disconnect(null);
        }
    }

    /**
     * send message to destination
     *
     * @param msg
     */
    public void publishMessage(String destination, String msg) {
        queue.add(futureConnection.publish(destination, msg.getBytes(), QoS.AT_LEAST_ONCE, false));
    }

    /**
     * send message to destination
     *
     * @param msg
     */
    public void publishRatainMessage(String destination, String msg) {
        queue.add(futureConnection.publish(destination, msg.getBytes(), QoS.AT_LEAST_ONCE, true));
    }


    public void onConnected() {
        System.out.println("------------mqtt--------connected");
    }

    public void onDisconnected() {
        hasConnected = false;
    }

    public void onFailure(Throwable arg0) {
        arg0.printStackTrace();
    }

    /**
     * MQTT has received data and callback the receiver
     */
    public void onPublish(UTF8Buffer topic, Buffer msg, Runnable ack) {
        String body = msg.utf8().toString();
        if (mqttCallBackService != null) {
            mqttCallBackService.onDataReceive(body);
        }
        ack.run();
    }

    /**
     * MQTT client has connected to the server and subscribe itself
     */
    public void onSuccess(Void arg0) {
        hasConnected = true;

        Topic[] topics = {new Topic(subscribe, QoS.AT_LEAST_ONCE)};

        connection.subscribe(topics, new Callback<byte[]>() {
            public void onSuccess(byte[] qoses) {
            }

            public void onFailure(Throwable value) {
                value.printStackTrace();
            }
        });

        new Thread(new Runnable() {

            public void run() {
                try {
                    futureConnection.connect().await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * return whether the client has connected to the server
     *
     * @return
     */
    public boolean isHasConnected() {
        return hasConnected;
    }

    public MqttCallBackService getMqttCallBackService() {
        return mqttCallBackService;
    }

    public void setMqttCallBackService(MqttCallBackService mqttCallBackService) {
        this.mqttCallBackService = mqttCallBackService;
    }
}
