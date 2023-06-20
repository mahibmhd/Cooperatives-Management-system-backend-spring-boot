package com.dxvalley.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.Account;
import com.dxvalley.project.models.AccountBalance;
import com.dxvalley.project.models.AccountInfo;
import com.dxvalley.project.models.AnnualTurnOver;
import com.dxvalley.project.models.AnnualTurnOverDto;
import com.dxvalley.project.models.Asset;
import com.dxvalley.project.models.AssetDto;
import com.dxvalley.project.models.Commodity;
import com.dxvalley.project.models.CommodityDto;
import com.dxvalley.project.models.LiabilityDto;
import com.dxvalley.project.models.Liabilty;
import com.dxvalley.project.models.Member;
import com.dxvalley.project.models.OsLoan;
import com.dxvalley.project.models.OsLoanDto;
import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.models.PaidUpShareDto;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.models.UnionsExportData;
import com.dxvalley.project.models.UnionsReportData;
import com.dxvalley.project.services.AccountBalanceService;
import com.dxvalley.project.services.AccountService;
import com.dxvalley.project.services.AnnualTurnOverService;
import com.dxvalley.project.services.AssetService;
import com.dxvalley.project.services.CommodityService;
import com.dxvalley.project.services.LiabilityService;
import com.dxvalley.project.services.MemberService;
import com.dxvalley.project.services.OsLoanService;
import com.dxvalley.project.services.PaidUpShareService;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/unionExport")
public class UnionsExpportDataController {
    @Autowired
    private final UnionService unionService;
    private final CommodityService commodityService;
    private final PrCooperativeService prCooperativeService;
    private final MemberService memberService;
    private final AccountService accountService;
    private final AccountBalanceService accountBalanceService;
    private final AnnualTurnOverService annualTurnOverService;
    private final AssetService assetService;
    private final LiabilityService liabilityService;
    private final PaidUpShareService paidUpShareService;
    private final OsLoanService osLoanService;
    
    private int no_of_Male_Stablishing_Member=0;
    private int no_of_Female_Stablishing_Member=0;
    private int no_of_Total_Stablishing_Member=0;
    private int no_of_male=0;
    private int no_of_female=0;

    @GetMapping("/getUnionsExport")
    List<UnionsExportData> getUnions() {
    List<UnionsExportData> unionsExportDatas= new ArrayList<UnionsExportData>();
    List<Unions> unions=unionService.getUnion();
    unions.stream().forEach(x->{
        UnionsExportData unionsExportData= new UnionsExportData();
        unionsExportData.setUnionName(x.getName());
        unionsExportData.setAddress(x.getAddress());
        unionsExportData.setType(x.getType());
        unionsExportData.setSector(x.getSector());
        List<Commodity> commodities=commodityService.getCommodityByUnion(x);
        List<CommodityDto> commodityDtos=new ArrayList<CommodityDto>();
        commodities.stream().forEach(c->{
            CommodityDto commodityDto= new CommodityDto();
            commodityDto.setCommodityName(c.getCommodityName());
            commodityDto.setType(c.getType());
            commodityDtos.add(commodityDto);
        });
        unionsExportData.setCommodities(commodityDtos);
        List<PrCooperative> aPrCooperatives=prCooperativeService.getPrCooperativeByUnionAndIsActive(x, true);
        unionsExportData.setNo_of_ActivePrCooperatives(aPrCooperatives.size());
        List<PrCooperative> naPrCooperatives=prCooperativeService.getPrCooperativeByUnionAndIsActive(x, false);
        unionsExportData.setNo_of_Non_ActivePrCooperatives(naPrCooperatives.size());
        List<PrCooperative> totalPrCooperatives=prCooperativeService.getPrCooperativeByUnion(x);



        unionsExportData.setTotal_No_of_PrCooperatives(totalPrCooperatives.size());
        List<Member> maleMembers=memberService.getMembersByUnionAndGender(x, "MALE");
        no_of_male=0;
        no_of_female=0;
        
        List<PrCooperative> prCooperatives=prCooperativeService.getPrCooperativeByUnion(x);
        prCooperatives.stream().forEach(p->{
            if(p.getNo_Of_FemaleMembers()!=null)
            {
                     no_of_female+=p.getNo_Of_FemaleMembers();
            }
            if(p.getNo_Of_MaleMembers()!=null)
            {
                    no_of_male+=p.getNo_Of_MaleMembers();
            }
            
           
        });
        unionsExportData.setNo_of_Male_Individual_Member(no_of_male);



        List<Member> femaleMembers=memberService.getMembersByUnionAndGender(x, "FEMALE");
        unionsExportData.setNo_of_Female_Individual_Member(no_of_female);


        List<Member> totalMembers=memberService.getMembersByUnion(x);
        unionsExportData.setTotal_no_of_Individual_Member(no_of_male+no_of_female);
        List<Account> accounts=accountService.getAccountByUnion(x);
        List<AccountInfo> accountInfos= new ArrayList<AccountInfo>();
        accounts.stream().forEach(y->{
            AccountInfo accountInfo= new AccountInfo();
            accountInfo.setAccountNumber(y.getAccountNumber());
            accountInfo.setBranch(y.getBranch());
            accountInfo.setDistrict(y.getDistrict());
            List<AccountBalance> accountBalances=accountBalanceService.getAccountBalancesByAccount(y);
            accountInfo.setAccountBalances(accountBalances);
            accountInfos.add(accountInfo);
        });
        unionsExportData.setAccountInfos(accountInfos);
        unionsExportData.setYearOfStablishment(x.getDateOfEstablishmnet());
        no_of_Male_Stablishing_Member=0;
        prCooperatives.stream().forEach(z->{
            if(z.getMaleMembersUpOnEstablishement()!=null){
                no_of_Male_Stablishing_Member+=z.getMaleMembersUpOnEstablishement();
            }
        });
        unionsExportData.setNo_of_Male_Stablishing_Member(no_of_Male_Stablishing_Member);

        no_of_Female_Stablishing_Member=0;
        prCooperatives.stream().forEach(a->{
            if(a.getFemaleMembersUpOnEstablishement()!=null)
            {
                no_of_Female_Stablishing_Member+=a.getFemaleMembersUpOnEstablishement();
            }
        });
        unionsExportData.setNo_of_Female_Stablishing_Member(no_of_Female_Stablishing_Member);
        no_of_Total_Stablishing_Member=0;
        totalMembers.stream().forEach(b->{
            if(b.getIsFounder()==true){
                no_of_Total_Stablishing_Member++;
            }
        });
        unionsExportData.setNo_of_Total_Stablishing_Member(no_of_Male_Stablishing_Member+no_of_Female_Stablishing_Member);
        unionsExportData.setShareCapitalUponEstablishmnet(x.getShareCapitalUponEstablishmnet());
        List<AnnualTurnOver> annualTurnOvers=annualTurnOverService.getAnnualTurnOverByUnion(x);
        List<AnnualTurnOverDto> annualTurnOverDtos= new ArrayList<AnnualTurnOverDto>();
        annualTurnOvers.stream().forEach(at->{
            AnnualTurnOverDto annualTurnOverDto= new AnnualTurnOverDto();
            annualTurnOverDto.setAnnualTurnOverValue(at.getAnnualTurnOverValue());
            annualTurnOverDto.setDateGenerated(at.getDateGenerated());
            annualTurnOverDtos.add(annualTurnOverDto);
        });
        unionsExportData.setAnnualTurnOvers(annualTurnOverDtos);
        List<Asset> assets=assetService.getAssetByUnion(x);
        List<AssetDto> assetDtos= new ArrayList<AssetDto>();
        assets.stream().forEach(as->{
            AssetDto assetDto= new AssetDto();
          //  assetDto.setAssetName(as.getAssetName());
            assetDto.setType(as.getType());
            assetDto.setValue(as.getValue());
            assetDtos.add(assetDto);
        });
        unionsExportData.setAssets(assetDtos);
        List<Liabilty> liabilties=liabilityService.getLiabiltyByUnion(x);
        List<LiabilityDto> liabilityDtos= new ArrayList<LiabilityDto>();
        liabilties.stream().forEach(l->{
            LiabilityDto liabilityDto= new LiabilityDto();
            liabilityDto.setLiabilityValue(l.getLiabilityValue());
            liabilityDto.setDateGenerated(l.getDateGenerated());
            liabilityDtos.add(liabilityDto);
        });
        unionsExportData.setLiabilities(liabilityDtos);
        List<PaidUpShare> paidUpShares=paidUpShareService.getPaidUpShareByUnion(x);
        List<PaidUpShareDto> paidUpShareDtos= new ArrayList<PaidUpShareDto>();
        paidUpShares.stream().forEach(p->{
            PaidUpShareDto paidUpShareDto= new PaidUpShareDto();
            paidUpShareDto.setPaidUpValue(p.getPaidUpValue());
            paidUpShareDto.setDateGenerated(p.getDateGenerated());
            paidUpShareDtos.add(paidUpShareDto);
            
        });
        unionsExportData.setPaidUpShares(paidUpShareDtos);
        List<OsLoan> osLoans=osLoanService.getOsLoansByUnion(x);
        List<OsLoanDto> osLoanDtos= new ArrayList<OsLoanDto>();
        osLoans.stream().forEach(os->{
            OsLoanDto osLoanDto= new OsLoanDto();
            osLoanDto.setOsLoanValue(os.getOsLoanValue());
            osLoanDto.setDateGenerated(os.getDateGenerated());
            osLoanDtos.add(osLoanDto);
        });
        unionsExportData.setOsLoans(osLoanDtos);
        unionsExportDatas.add(unionsExportData);
    });
    return unionsExportDatas;
  }

  @GetMapping("/getUnionsReport")
  List<UnionsReportData> getUnioons() {
    List<UnionsReportData> unionsReportDatas= new ArrayList<UnionsReportData>();
    List<Unions> unions=unionService.getUnion();
    unions.stream().forEach(m->{
        UnionsReportData unionsReportData= new UnionsReportData();
        unionsReportData.setUnionName(m.getName());
        unionsReportData.setDateOfEstablishmnet(m.getDateOfEstablishmnet());
        unionsReportData.setNo_Of_MaleMembers(m.getNo_Of_MaleMembers());
        unionsReportData.setNo_Of_FemaleMembers(m.getNo_Of_FemaleMembers());
        unionsReportData.setMaleMembersUpOnEstablishement(m.getMaleMembersUpOnEstablishement());
        unionsReportData.setFemaleMembersUpOnEstablishement(m.getFemaleMembersUpOnEstablishement());
       // unionsReportData.setLicensingOrgan(m.getLicensingOrgan());
       
      List<Member> maleMembers=memberService.getMembersByUnionAndGender(m, "MALE"); 
              no_of_Male_Stablishing_Member=0;
              maleMembers.stream().forEach(z->{
                  if(z.getIsFounder()==true){
                      no_of_Male_Stablishing_Member++;
                  }
              });
              List<Member> femaleMembers=memberService.getMembersByUnionAndGender(m, "FEMALE");
              no_of_Female_Stablishing_Member=0;
              femaleMembers.stream().forEach(a->{
                  if(a.getIsFounder()==true)
                  {
                      no_of_Female_Stablishing_Member++;
                  }
              });
            
              unionsReportData.setMaleMembersUpOnEstablishement(no_of_Male_Stablishing_Member);
              unionsReportData.setFemaleMembersUpOnEstablishement(no_of_Female_Stablishing_Member);
            
            List<Member> totalMembers=memberService.getMembersByUnion(m);
              no_of_Total_Stablishing_Member=0;
              totalMembers.stream().forEach(b->{
                  if(b.getIsFounder()==true){
                      no_of_Total_Stablishing_Member++;
                  }
              });
              unionsReportData.setNo_of_Total_Stablishing_Member(no_of_Total_Stablishing_Member);
      // unionsReportData.setNo_of_Total_Stablishing_Member(no_of_Total_Stablishing_Member);
       unionsReportData.setShareCapitalUponEstablishmnet(m.getShareCapitalUponEstablishmnet());
       unionsReportDatas.add(unionsReportData);
    });
    return unionsReportDatas;
}


}
