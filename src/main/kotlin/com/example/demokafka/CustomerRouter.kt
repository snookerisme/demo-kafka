package com.example.demokafka

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class CustomerRouter {

    @Bean
    fun demoRoutes(customerHandler: CustomerHandler
    ) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            POST("/produce", customerHandler::produce)
        }
    }

}