package com.example.demokafka.kafka

import com.example.demokafka.kafka.config.KafkaProduceClient
import com.example.demokafka.kafka.entites.CustomerData
import com.example.demokafka.utils.KafkaConstants.CUSTOMER_DESTINATION_OUT
import org.springframework.stereotype.Component

@Component
class StreamProduce(
    private val kafkaProduceClient: KafkaProduceClient
) {

    fun customerProduce(data:CustomerData){
        kafkaProduceClient.produce(CUSTOMER_DESTINATION_OUT,data)
    }
}