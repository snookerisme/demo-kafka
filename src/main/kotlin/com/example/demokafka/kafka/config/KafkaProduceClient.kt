package com.example.demokafka.kafka.config

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.stereotype.Component

@Component
class KafkaProduceClient(
    private val streamBridge: StreamBridge
) {

    fun produce(bindingName: String, data: Any) =
        send(bindingName, data)


    private fun send(bindingName: String, data: Any) = streamBridge.runCatching {
        send(bindingName, data).takeIf {
            it
        }?.run {
            println("Produce data success => $data")
        }?: println("Produce data fail!!")
    }.onFailure {
        println(it.message)
    }.getOrThrow()
}