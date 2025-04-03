package com.ian.demo.mongodb.analytics.service;

import com.ian.demo.mongodb.analytics.entity.Account;
import com.ian.demo.mongodb.analytics.entity.Customer;
import com.ian.demo.mongodb.analytics.entity.Transaction;
import com.ian.demo.mongodb.analytics.model.AggregatedTransaction;
import com.ian.demo.mongodb.analytics.model.CustomerAccounts;
import com.ian.demo.mongodb.analytics.repository.AccountRepository;
import com.ian.demo.mongodb.analytics.repository.AnalyticsRepository;
import com.ian.demo.mongodb.analytics.repository.CustomerRepository;
import com.ian.demo.mongodb.analytics.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    private final AnalyticsRepository analyticsRepository;

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public CustomerAccounts getCustomerAccounts(String username) {
        return analyticsRepository.getCustomerAccounts(username);
    }

    public AggregatedTransaction getAggregatedTransaction(Integer accountId, String symbol,
        String transactionCode) {
        return analyticsRepository.getAggregatedTransaction(accountId, symbol, transactionCode);
    }

}
