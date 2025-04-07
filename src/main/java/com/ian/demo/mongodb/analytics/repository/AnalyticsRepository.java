package com.ian.demo.mongodb.analytics.repository;

import com.ian.demo.mongodb.analytics.entity.Account;
import com.ian.demo.mongodb.analytics.entity.Customer;
import com.ian.demo.mongodb.analytics.entity.Transaction;
import com.ian.demo.mongodb.analytics.model.AggregatedTransaction;
import com.ian.demo.mongodb.analytics.model.CustomerAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AddFieldsOperation;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Divide;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
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
        MatchOperation match = Aggregation.match(Criteria.where(Customer.F_USERNAME).is(username));
        ProjectionOperation project1 = Aggregation.project(Customer.F_USERNAME,
            Customer.F_ACCOUNTS);
        LookupOperation lookup = Aggregation.lookup(Account.COLLECTION, Customer.F_ACCOUNTS,
            Account.F_ACCOUNT_ID, CustomerAccounts.F_ACCOUNTS);
        ProjectionOperation project2 = Aggregation.project(Customer.F_USERNAME,
            CustomerAccounts.F_ACCOUNTS, CustomerAccounts.F_ACCOUNTS_ACCOUNT_ID,
            CustomerAccounts.F_ACCOUNTS_LIMIT, CustomerAccounts.F_ACCOUNTS_PRODUCTS);
        Aggregation aggregation = Aggregation.newAggregation(match, project1, lookup, project2);
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
        MatchOperation matchAccountId = Aggregation.match(
            Criteria.where(Transaction.F_ACCOUNT_ID).is(accountId));
        UnwindOperation unwind = Aggregation.unwind(Transaction.F_TRANSACTIONS);
        MatchOperation matchSymbolAndCode = Aggregation.match(
            Criteria.where(Transaction.F_TRANSACTIONS_SYMBOL).is(symbol)
                .and(Transaction.F_TRANSACTIONS_TRANSACTION_CODE).is(transactionCode));
        ProjectionOperation project = Aggregation.project(Transaction.F_ACCOUNT_ID,
                Transaction.F_BUCKET_START_DATE, Transaction.F_BUCKET_END_DATE)
            .and(Transaction.F_TRANSACTIONS_AMOUNT).as(AggregatedTransaction.F_AMOUNT)
            .and(Transaction.F_TRANSACTIONS_TRANSACTION_CODE)
            .as(AggregatedTransaction.F_TRANSACTION_CODE)
            .and(Transaction.F_TRANSACTIONS_SYMBOL).as(AggregatedTransaction.F_SYMBOL)
            .and(ConvertOperators.valueOf(Transaction.F_TRANSACTIONS_PRICE).convertToDecimal())
            .as(AggregatedTransaction.F_PRICE)
            .and(ConvertOperators.valueOf(Transaction.F_TRANSACTIONS_TOTAL).convertToDecimal())
            .as(AggregatedTransaction.F_TOTAL);
        GroupOperation group = Aggregation.group(Transaction.F_ACCOUNT_ID)
            .first(Transaction.F_ACCOUNT_ID).as(AggregatedTransaction.F_ACCOUNT_ID)
            .first(AggregatedTransaction.F_SYMBOL).as(AggregatedTransaction.F_SYMBOL)
            .first(AggregatedTransaction.F_TRANSACTION_CODE)
            .as(AggregatedTransaction.F_TRANSACTION_CODE)
            .sum(AggregatedTransaction.F_AMOUNT).as(AggregatedTransaction.F_AMOUNT)
            .sum(AggregatedTransaction.F_TOTAL).as(AggregatedTransaction.F_TOTAL);
        AddFieldsOperation addFields = Aggregation.addFields()
            .addField(AggregatedTransaction.F_PRICE).withValueOf(
                Divide.valueOf(AggregatedTransaction.F_TOTAL)
                    .divideBy(AggregatedTransaction.F_AMOUNT)).build();
        Aggregation aggregation = Aggregation.newAggregation(matchAccountId, unwind,
            matchSymbolAndCode, project, group, addFields);
        return mongoTemplate.aggregate(aggregation, Transaction.COLLECTION,
            AggregatedTransaction.class).getUniqueMappedResult();
    }

}
