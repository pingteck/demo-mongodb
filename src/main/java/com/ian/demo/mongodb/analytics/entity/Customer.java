package com.ian.demo.mongodb.analytics.entity;

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
@Document("customers")
public class Customer {

    public static final String COLLECTION = "customers";

    public static final String F_ID = "id";
    public static final String F_ACCOUNTS = "accounts";
    public static final String F_EMAIL = "email";
    public static final String F_NAME = "name";
    public static final String F_TIER_AND_DETAILS = "tier_and_details";
    public static final String F_USERNAME = "username";
    public static final String F_ACTIVE = "active";
    public static final String F_ADDRESS = "address";
    public static final String F_BIRTHDATE = "birthdate";

    private String id;
    private List<Integer> accounts;
    private String email;
    private String name;
    @Field("tier_and_details")
    private Object tierAndDetails;
    private String username;
    private Boolean active;
    private String address;
    private Instant birthdate;

}
