package com.pixelkafkacamel.kafkaroute;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("kafka:localhost:9092?topic=mytopic&groupId=group1&consumersCount=1&autoOffsetReset=smallest")
                .log("${body}")
                .to("direct:readFromKafka");

        //With SSL
        /*from("kafka:localhost:9092?topic=my-first-topic&groupId=group1&consumersCount=1&autoOffsetReset=latest&securityProtocol=SSL&sslKeystoreLocation=${sslKeystorePath}&sslKeystorePassword=${sslKeystorePassword}&sslTruststoreLocation=${sslTruststorePath}&sslTruststorePassword=${sslTruststorePassword}")
         .log("${body}")
                .to("direct:readFromKafka");
*/
    }
}