package com.backbase.atm.service.impl;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CamelServiceImpl extends RouteBuilder {

    @Override
    public void configure() {

        from("timer:hello?period={{camel.springboot.timer}}")
                .to("http4:{{camel.springboot.consumer}}")
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
                .to("http4:{{camel.springboot.producer}}");

    }

}
