package com.demo.mqtt.consumer.upstream.handle;


import com.demo.mqtt.consumer.upstream.message.DeviceUpMsg;
import com.dev.mqtt.client.consumer.handle.IMessageHandler;
import com.dev.mqtt.client.consumer.pojo.ConsumeResult;
import com.dev.mqtt.client.consumer.pojo.SslwMessage;
import com.dev.mqtt.client.starter.core.MqttListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractDeviceMessageHandle<R extends DeviceUpMsg> implements MqttListener<SslwMessage>, IMessageHandler<R> {

    @Override
    public ConsumeResult onMessage(SslwMessage message) {
        R msg = analysis(message.getPayload());

        msg.setDeviceId(message.getIdentifier());
        msg.setTopic(message.getTopic());
        msg.setQos(message.getQos());
        msg.setConsumeAt(message.getConsumeAt());

        preHandle(msg);
        ConsumeResult result = handle(msg);
        log.info("receive mqtt message: {}", result);
        afterHandle(msg);
        return result;
    }

    @Override
    public void preHandle(R msg) {
    }

    @Override
    public ConsumeResult handle(R msg) {
        return doHandle(msg);
    }

    @Override
    public void afterHandle(R msg) {

    }

    /**
     * 解析payload
     *
     * @param payload payload
     * @return R extends {@link DeviceUpMsg}
     */
    protected abstract R analysis(byte[] payload);

    /**
     * 处理
     *
     * @param message 消息实体对象
     * @return {@link ConsumeResult}
     */
    protected abstract ConsumeResult doHandle(R message);
}
