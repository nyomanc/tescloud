package com.example.demo.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutUserOutputSchema {
    private String nip;
    private String nama;
    private String email;
}
