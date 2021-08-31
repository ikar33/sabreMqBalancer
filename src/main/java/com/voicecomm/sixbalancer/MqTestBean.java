package com.voicecomm.sixbalancer;

import org.apache.camel.Exchange;

public class MqTestBean {

    public void process(Exchange exchange){
        exchange.getIn().setHeader("MQ.HEADER","TEST_1");
        exchange.getIn().setHeader("JMSType","TEST_TYPE");
        System.out.println(exchange.getIn().getBody(String.class));
    }
    
}
