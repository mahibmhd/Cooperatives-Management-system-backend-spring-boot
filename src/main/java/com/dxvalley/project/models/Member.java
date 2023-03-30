package com.dxvalley.project.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long memberId;
    private String fullName;
    private String gender;
    private Boolean isFounder;
    @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="date_created")
    private String dateCreated;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    //asset with union
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "union_Id")
	private Unions unionId;

    //asset with prCooperative
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prCooperative_Id")
	private PrCooperative prCooperativeId;
    
}
