package com.ian.demo.mongodb.analytics.model;

import com.ian.demo.mongodb.analytics.entity.Account;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CustomerAccounts {

    public static final String F_USERNAME = "username";
    public static final String F_ACCOUNTS = "accounts";
    public static final String F_ACCOUNTS_ACCOUNT_ID = "accounts.account_id";
    public static final String F_ACCOUNTS_LIMIT = "accounts.limit";
    public static final String F_ACCOUNTS_PRODUCTS = "accounts.products";

    private String id;
    private String username;
    private List<Account> accounts;

}
