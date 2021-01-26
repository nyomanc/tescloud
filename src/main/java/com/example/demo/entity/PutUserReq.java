package com.example.demo.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutUserReq {
    private String nama;
    private String email;
    private String password;

    public PutUserReq(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }
}
