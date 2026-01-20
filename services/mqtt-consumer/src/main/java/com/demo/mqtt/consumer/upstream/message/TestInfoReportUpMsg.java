package com.demo.mqtt.consumer.upstream.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestInfoReportUpMsg extends DeviceUpMsg {

    private String testInfo;

}
