package com.dxvalley.project.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private String branch;
    private String district;
}
