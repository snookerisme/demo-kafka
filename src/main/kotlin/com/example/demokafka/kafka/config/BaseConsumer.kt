package com.example.demokafka.kafka.config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.runBlocking

open class BaseConsumer {

    fun <T, R> processConsumer(
        payload: String,
        type: Class<T>,
        process: suspend (T) -> R
    ) {
        val data: T
        try {
            data = jacksonObjectMapper().readValue(payload, type)
        } catch (ex: Exception) {
            throw ex
        }

        try {
            runBlocking {
                process(data)
            }
        } catch (ex: Exception) {
            throw ex
        }
    }
}