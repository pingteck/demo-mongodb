package com.ian.demo.mongodb.analytics.controller;

import com.ian.demo.mongodb.analytics.entity.Account;
import com.ian.demo.mongodb.analytics.entity.Customer;
import com.ian.demo.mongodb.analytics.entity.Transaction;
import com.ian.demo.mongodb.analytics.model.AggregatedTransaction;
import com.ian.demo.mongodb.analytics.model.CustomerAccounts;
import com.ian.demo.mongodb.analytics.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/analytics/v1")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {
        return ResponseEntity.ok(analyticsService.getAccounts());
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(analyticsService.getCustomers());
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getTransactions() {
        return ResponseEntity.ok(analyticsService.getTransactions());
    }

    @GetMapping("/customer/accounts/{username}")
    public ResponseEntity<CustomerAccounts> getCustomerAccounts(@PathVariable String username) {
        return ResponseEntity.ok(analyticsService.getCustomerAccounts(username));
    }

    @GetMapping("/transaction/aggregated")
    public ResponseEntity<AggregatedTransaction> getAggregatedTransaction(
        @RequestParam Integer accountId, @RequestParam String symbol,
        @RequestParam String transactionCode) {
        return ResponseEntity.ok(
            analyticsService.getAggregatedTransaction(accountId, symbol, transactionCode));
    }

}
