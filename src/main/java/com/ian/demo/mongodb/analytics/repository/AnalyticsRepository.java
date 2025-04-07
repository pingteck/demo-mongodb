package com.ian.demo.mongodb.analytics.repository;

import com.ian.demo.mongodb.analytics.entity.Customer;
import com.ian.demo.mongodb.analytics.entity.Transaction;
import com.ian.demo.mongodb.analytics.model.AggregatedTransaction;
import com.ian.demo.mongodb.analytics.model.CustomerAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnalyticsRepository {

    private final MongoTemplate mongoTemplate;

    /*
    Exercise 1
    Implement AnalyticsRepository.getCustomerAccounts()

    Get associated account information under a single customer
        - customers.username: fmiller
        - customers.accounts[] -> account_id
    Hint:
        - Try using MongoDB Compass to write the aggregation pipeline with:
            - $match, $project, $lookup, $project
     */
    public CustomerAccounts getCustomerAccounts(String username) {
        Aggregation aggregation = Aggregation.newAggregation();
        return mongoTemplate.aggregate(aggregation, Customer.COLLECTION, CustomerAccounts.class)
            .getUniqueMappedResult();
    }

    /*
    Exercise 2
    Implement Analytics.getAggregatedTransaction()

    Combine all transactions with the same account ID, symbol and transaction code.
    Sum amount and sum total to derive price (total / amount = price)
        - account_id: 627788
        - symbol: nvda
        - transaction_code: buy
    Hint:
        - Try using MongoDB Compass to write the aggregation pipeline with:
            - $match, $unwind, $match, $project, $group, $set/$addField
     */
    public AggregatedTransaction getAggregatedTransaction(Integer accountId, String symbol,
        String transactionCode) {
        Aggregation aggregation = Aggregation.newAggregation();
        return mongoTemplate.aggregate(aggregation, Transaction.COLLECTION,
            AggregatedTransaction.class).getUniqueMappedResult();
    }

}
