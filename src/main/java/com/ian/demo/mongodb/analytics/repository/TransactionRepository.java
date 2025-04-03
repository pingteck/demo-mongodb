package com.ian.demo.mongodb.analytics.repository;

import com.ian.demo.mongodb.analytics.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
