package com.voicecomm.sixbalancer;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CamelUtilsBean {
    private static final Logger logger = LoggerFactory.getLogger(CamelUtilsBean.class);

    public void systemOut(String message) {
        System.out.println(message);
    }

    public void replacePrepareBodyForDb(Exchange exchange, String src, String replacement) {
        logger.info("Starting CamelUtilsBean.replacePrepareBodyForDb() before adding to DB");
        exchange.getIn().setBody(exchange.getIn().getBody(String.class).replace("'", "''"), String.class);
    }

    public void test(Exchange exchange) {
        System.out.println(exchange.getIn().getBody(String.class));
    }

}
