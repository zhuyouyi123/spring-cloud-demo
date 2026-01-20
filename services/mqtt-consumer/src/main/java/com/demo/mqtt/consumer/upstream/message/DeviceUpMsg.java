package com.demo.mqtt.consumer.upstream.message;

import lombok.Data;

@Data
public class DeviceUpMsg {

    private String deviceId;

    private String topic;

    private int qos;

    /**
     * 开始消费时间
     */
    private long consumeAt;

    /**
     * 原始数据
     */
    private byte[] payload;

}
