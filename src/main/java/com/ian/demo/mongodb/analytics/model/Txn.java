package com.ian.demo.mongodb.analytics.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@ToString
public class Txn {

    private Instant date;
    private Integer amount;
    @Field("transaction_code")
    private String transactionCode;
    private String symbol;
    private BigDecimal price;
    private BigDecimal total;

}
