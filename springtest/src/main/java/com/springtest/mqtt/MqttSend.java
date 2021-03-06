package com.springtest.mqtt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.google.common.io.Files;

public class MqttSend {

	//tcp://MQTT安装的服务器地址:MQTT定义的端口号  
    public static final String HOST = "tcp://127.0.0.1:18883";  
    //定义一个主题  
    public static final String TOPIC = "ACTDG/ACTIA000000000011/STATUS";  
    //定义MQTT的ID，可以在MQTT服务配置中指定  
    private static final String clientid = "server11";  
  
    private MqttClient client;  
    private MqttTopic topic11;  
    private String userName = "ACTIA000000000011";  
    private String passWord = "ACTIA000000000011";  
  
    private MqttMessage message;  
  
    /** 
     * 构造函数 
     * @throws MqttException 
     */  
    public MqttSend() throws MqttException {  
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存  
        client = new MqttClient(HOST, clientid, new MemoryPersistence());  
        connect();  
    }  
  
    /** 
     *  用来连接服务器 
     */  
    private void connect() {  
        MqttConnectOptions options = new MqttConnectOptions();  
        options.setCleanSession(false);  
        options.setUserName(userName);  
        options.setPassword(passWord.toCharArray());  
        // 设置超时时间  
        options.setConnectionTimeout(10);  
        // 设置会话心跳时间  
        options.setKeepAliveInterval(20);  
        try {  
            client.setCallback(new PushCallback());  
            client.connect(options);  
  
            topic11 = client.getTopic(TOPIC);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 
     * @param topic 
     * @param message 
     * @throws MqttPersistenceException 
     * @throws MqttException 
     */  
    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,  
            MqttException {  
        MqttDeliveryToken token = topic.publish(message);  
        token.waitForCompletion();  
        System.out.println("message is published completely! "  
                + token.isComplete());  
    }  
  
    public void sendMsg(byte[] b) throws Exception {
    	 this.message = new MqttMessage();  
         this.message.setQos(1);  
         this.message.setRetained(true);
         this.message.setPayload(b);  
         this.publish(this.topic11 , this.message);  
         System.out.println(this.message.isRetained() + "------ratained状态");  
         this.client.disconnect();
         this.client.close();
    }
    /** 
     *  启动入口 
     * @param args 
     * @throws MqttException 
     * @throws IOException 
     */  
    public static void main(String[] args) throws Exception {  
    	MqttSend server = new MqttSend();  
    	 File file = new File("C:/actia/1111/ACTIA000000000011.basic.20171113215439");
         InputStream input  = new FileInputStream(file);
 		byte[] b = new byte[(int)file.length()];
 		input.read(b);
 		input.close();
 		server.sendMsg(b);
       
    }  

}
