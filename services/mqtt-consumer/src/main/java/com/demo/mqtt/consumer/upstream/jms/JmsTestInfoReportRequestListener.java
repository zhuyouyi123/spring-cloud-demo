package com.demo.mqtt.consumer.upstream.jms;


import com.demo.mqtt.consumer.upstream.handle.AbstractDeviceJsonMessageHandle;
import com.demo.mqtt.consumer.upstream.message.TestInfoReportUpMsg;
import com.dev.mqtt.client.consumer.pojo.ConsumeResult;
import com.dev.mqtt.client.starter.annotation.MqttMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@MqttMessageListener(topicFilter = "test/+/info")
public class JmsTestInfoReportRequestListener extends AbstractDeviceJsonMessageHandle<TestInfoReportUpMsg> {

    @Override
    protected ConsumeResult doHandle(TestInfoReportUpMsg message) {
        String deviceId = message.getDeviceId();
        Object downMsg = new Object();
        return ConsumeResult.successWithAck(String.format("test/%s/infoAck", deviceId), downMsg);
    }

    @Override
    protected Class<TestInfoReportUpMsg> clazz() {
        return TestInfoReportUpMsg.class;
    }
}
