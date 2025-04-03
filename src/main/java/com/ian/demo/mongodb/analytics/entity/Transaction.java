package com.ian.demo.mongodb.analytics.entity;

import com.ian.demo.mongodb.analytics.model.Txn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@Document("transactions")
public class Transaction {

    public static final String COLLECTION = "transactions";

    public static final String F_ID = "id";
    public static final String F_BUCKET_END_DATE = "bucket_end_date";
    public static final String F_TRANSACTION_COUNT = "transaction_count";
    public static final String F_ACCOUNT_ID = "account_id";
    public static final String F_BUCKET_START_DATE = "bucket_start_date";
    public static final String F_TRANSACTIONS = "transactions";

    public static final String F_TRANSACTIONS_AMOUNT = "transactions.amount";
    public static final String F_TRANSACTIONS_TRANSACTION_CODE = "transactions.transaction_code";
    public static final String F_TRANSACTIONS_SYMBOL = "transactions.symbol";
    public static final String F_TRANSACTIONS_PRICE = "transactions.price";
    public static final String F_TRANSACTIONS_TOTAL = "transactions.total";

    private String id;
    @Field("bucket_end_date")
    private Instant bucketEndDate;
    @Field("transaction_count")
    private Integer transactionCount;
    @Field("account_id")
    private Integer accountId;
    @Field("bucket_start_date")
    private Instant bucketStartDate;
    private List<Txn> transactions;

}
