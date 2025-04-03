package com.ian.demo.mongodb.analytics.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@ToString
@Document("accounts")
public class Account {

    public static final String COLLECTION = "accounts";

    public static final String F_ID = "id";
    public static final String F_ACCOUNT_ID = "account_id";
    public static final String F_LIMIT = "limit";
    public static final String F_PRODUCTS = "products";

    private String id;
    @Field("account_id")
    private Integer accountId;
    private Integer limit;
    private List<String> products;

}
