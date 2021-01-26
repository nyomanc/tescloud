package com.example.demo.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GetUserResp extends BaseResp {
    private GetUserOutputSchema outputSchema;
}
