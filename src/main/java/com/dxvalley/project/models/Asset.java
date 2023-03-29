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
public class Asset {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long assetId;
    private String assetName;
    private Double value;
    private String type;
}
