package com.demo.mqtt.consumer.upstream.handle;

import com.alibaba.fastjson.JSON;
import com.demo.mqtt.consumer.upstream.message.DeviceUpMsg;

import java.nio.charset.Charset;

public abstract class AbstractDeviceJsonMessageHandle<M extends DeviceUpMsg> extends AbstractDeviceMessageHandle<M> {
    @Override
    protected M analysis(byte[] payload) {
        return JSON.parseObject(new String(payload, Charset.defaultCharset()), clazz());
    }

    protected abstract Class<M> clazz();

}
