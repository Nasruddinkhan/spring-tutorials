package com.mypractice.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataRoute extends RouteBuilder {

    @Value("${files.source-location}")
    private String sourceLocation;

    @Value("${files.destination-location}")
    private String destinationLocation;

    @Override
    public void configure() throws Exception {
        from("{{files.source-location}}")
                .to("{{files.destination-location}}" );
    }
}
