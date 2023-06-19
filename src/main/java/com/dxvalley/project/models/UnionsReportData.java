package com.dxvalley.project.models;

import lombok.Data;

@Data
public class UnionsReportData {
    
    private String unionName;
    private String dateOfEstablishmnet;
    private Integer no_of_Total_Stablishing_Member;
    private Double shareCapitalUponEstablishmnet;
    private String licensingOrgan;
    private Integer no_Of_MaleMembers;
    private Integer no_Of_FemaleMembers;
    private Integer maleMembersUpOnEstablishement;
    private Integer femaleMembersUpOnEstablishement; 
}
