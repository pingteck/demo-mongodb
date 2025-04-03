package com.ian.demo.mongodb.mflix.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document("users")
public class User {

    public static final String F_ID = "id";
    public static final String F_EMAIL = "email";
    public static final String F_NAME = "name";
    public static final String F_PASSWORD = "password";

    @Id
    private String id;
    private String email;
    private String name;
    private String password;

}