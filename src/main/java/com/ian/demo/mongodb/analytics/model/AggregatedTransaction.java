package com.ian.demo.mongodb.analytics.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class AggregatedTransaction {

    public static final String F_ACCOUNT_ID = "account_id";
    public static final String F_SYMBOL = "symbol";
    public static final String F_TRANSACTION_CODE = "transaction_code";
    public static final String F_AMOUNT = "amount";
    public static final String F_TOTAL = "total";
    public static final String F_PRICE = "price";

    @Field("account_id")
    private Integer accountId;
    private String symbol;
    @Field("transaction_code")
    private String transactionCode;
    private BigDecimal amount;
    private BigDecimal total;
    private BigDecimal price;

}
