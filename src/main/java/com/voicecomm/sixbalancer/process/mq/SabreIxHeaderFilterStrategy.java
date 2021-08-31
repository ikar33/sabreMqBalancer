package com.voicecomm.sixbalancer.process.mq;

import org.apache.camel.Exchange;
import org.apache.camel.spi.HeaderFilterStrategy;

public class SabreIxHeaderFilterStrategy implements HeaderFilterStrategy {
    @Override
    public boolean applyFilterToCamelHeaders(String headerName, Object headerValue, Exchange exchange) {
        return true;
    }

    @Override
    public boolean applyFilterToExternalHeaders(String headerName, Object headerValue, Exchange exchange) {
        return true;
    }
}
