package org.springframework.sbm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.http.dsl.Http;

@Configuration
public class FlowConfigurations {
    @Bean
    IntegrationFlow test_mule_migration_2Flow() {
        return IntegrationFlows.from(Http.inboundGateway("/test1")).handle((p, h) -> p)
                .handle((p, h) -> "This is sample payload string")
                .log(LoggingHandler.Level.INFO, "Payload content is: ${payload}")
                .get();
    }

    @Bean
    IntegrationFlow test_mule_migration_2Flow1() {
        return IntegrationFlows.from(Http.inboundGateway("/test2")).handle((p, h) -> p)
                .log(LoggingHandler.Level.INFO, "Payload content is: ${payload}")
                .get();
    }
}