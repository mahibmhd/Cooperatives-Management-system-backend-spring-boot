package com.dxvalley.project.models;
import org.springframework.data.jpa.repository.Query;

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
public class AnnualSell {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long annualSellId;
    private Double annualSellValue;
    @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="date_generated")
    private String dateGenerated;
    //annual sell with prCooperative
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prCooperative_Id")
	private PrCooperative prCooperative;



//     @Query( "SELECT pg FROM Book bk join bk.pages pg WHERE bk.bookId = :bookId")
//  List<Page> findPagesByBookId(@Param("bookId") String bookId);

}

