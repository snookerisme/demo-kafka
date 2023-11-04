package com.example.demokafka.service

import com.example.demokafka.dto.Response
import com.example.demokafka.kafka.StreamProduce
import com.example.demokafka.kafka.entites.CustomerData
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val streamProduce: StreamProduce
) {

    suspend fun saveCustomer(customerData: CustomerData): Response<CustomerData> {
        streamProduce.customerProduce(customerData)
        return Response(data = customerData)
    }
}