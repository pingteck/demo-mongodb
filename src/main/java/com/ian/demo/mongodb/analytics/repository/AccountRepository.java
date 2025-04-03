package com.ian.demo.mongodb.analytics.repository;

import com.ian.demo.mongodb.analytics.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

}
