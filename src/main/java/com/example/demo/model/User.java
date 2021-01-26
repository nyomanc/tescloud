package com.example.demo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@DynamicUpdate
@Table(name="TBL_USER")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {
    @Id
    private String nip;
    private String email;
    @Column(nullable = false)
    private String nama;
    @Column(nullable = false, name = "PASSWORD")
    private String password;

    public User() {

    }
}
