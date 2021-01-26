package com.example.demo.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BaseResp {
    protected String errorMessage;
    protected String errorCode;
    protected String timestamp;




    public void setDefaultTimestamp() {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}