package com.dxvalley.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class AnnualTurnOver {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long annualTurnOverId;
    private Double annualTurnOverValue;
    @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="date_generated")
    private String dateGenerated;

    //annual turn over with union
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "union_Id")
	private Unions union;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prCooperative_Id")
    private PrCooperative prCooperative;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "federation_Id")
    private Federations federation;
}
