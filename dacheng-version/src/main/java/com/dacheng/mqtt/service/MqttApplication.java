package com.dacheng.mqtt.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.dacheng.mqtt.MQTTUtils;

/**
 * Created by KaiWang on 16/8/30.
 */

/*@Configuration
@ComponentScan
@PropertySource("classpath:mqtt.properties")*/
public class MqttApplication {

//    @Bean(destroyMethod = "shutdown")
//    public RedissonClient redisson(@Value("classpath:/redisson.json") Resource configFile) throws IOException {
//        Config config = Config.fromJSON(configFile.getInputStream());
//        return Redisson.create(config);
//    }

 /*   @Bean
    @Scope("singleton")  //actually default is singleton
    public MQTTUtils mqttUtils(MqttCallBackService mqttCallBackService,
                               @Value("#{mqtt['mqtt.host']}") String host,
                               @Value("#{mqtt['mqtt.port']}") int port,
                               @Value("#{mqtt['mqtt.user']}") String user,
                               @Value("#{mqtt['mqtt.password']}") String password,
                               @Value("#{mqtt['mqtt.subscribe']}") String subscribe){
        System.out.println("----------------- init  mqtt utils -----------------");

        MQTTUtils mqttUtils=MQTTUtils.getInstance(host,port,user,password,subscribe);
        mqttUtils.setMqttCallBackService(mqttCallBackService);
        mqttUtils.startListener();
        return mqttUtils;
    }*/

    //You need this
/*    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
