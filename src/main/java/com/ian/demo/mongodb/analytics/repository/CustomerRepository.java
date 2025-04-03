package com.ian.demo.mongodb.analytics.repository;

import com.ian.demo.mongodb.analytics.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
