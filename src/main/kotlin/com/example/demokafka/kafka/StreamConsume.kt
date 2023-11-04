package com.example.demokafka.kafka

import com.example.demokafka.kafka.config.BaseConsumer
import com.example.demokafka.kafka.entites.CustomerData
import com.example.demokafka.utils.KafkaConstants.CUSTOMER_DESTINATION_IN
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class StreamConsume : BaseConsumer() {

    @Bean
    fun customerConsume(): Consumer<String> = Consumer {
        processConsumer(it, CustomerData::class.java) { payload ->
            println("Consume data success => $payload")
        }
    }

}