package com.dxvalley.project.models;
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
public class Commodity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long commodityId;
    private String commodityName;
    private String type;

    //commodity union
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "union_id")
	private Unions unionId;

     //commodity union
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "prcooperative_id")
     private PrCooperative prCooperativeId;
}
