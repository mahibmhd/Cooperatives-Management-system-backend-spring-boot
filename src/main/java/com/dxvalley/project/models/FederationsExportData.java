package com.dxvalley.project.models;

import java.util.List;

import lombok.Data;

@Data
public class FederationsExportData {
   
    private String federationName;
    private Address address;
    private  Type type;
    private Sector sector;
    private List<CommodityDto> Commodities;
    private Integer no_of_ActivePrCooperatives;
    private Integer no_of_Non_ActivePrCooperatives;
    private Integer total_No_of_PrCooperatives;
        private Integer no_of_Male_Individual_Member;
        private Integer no_of_Female_Individual_Member;
        private Integer Total_no_of_Individual_Member;
        private List<AccountInfo> accountInfos;
        private String yearOfStablishment;
        private Double shareCapitalUponEstablishmnet;
        private Integer no_of_Male_Establishing_Member;
        private Integer no_of_Female_Establishing_Member;
        private Integer no_of_Total_Establishing_Member;
        private List<AnnualTurnOverDto> annualTurnOvers;
        private List<AssetDto> assets;
        private List<LiabilityDto> liabilities;
        private List<PaidUpShareDto> paidUpShares;
        private List<OsLoanDto> osLoans;


  
    
}
