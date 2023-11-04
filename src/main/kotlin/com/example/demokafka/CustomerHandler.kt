package com.example.demokafka

import com.example.demokafka.kafka.entites.CustomerData
import com.example.demokafka.service.CustomerService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class CustomerHandler(
    private val customerService: CustomerService
) {
    suspend fun produce(request: ServerRequest) = request.awaitBody<CustomerData>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(customerService.saveCustomer(it))
        }
}