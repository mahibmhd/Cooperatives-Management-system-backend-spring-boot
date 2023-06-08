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
import com.dxvalley.project.models.Federations;
import com.dxvalley.project.models.FederationsExportData;
import com.dxvalley.project.models.LiabilityDto;
import com.dxvalley.project.models.Liabilty;
import com.dxvalley.project.models.Member;
import com.dxvalley.project.models.OsLoan;
import com.dxvalley.project.models.OsLoanDto;
import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.models.PaidUpShareDto;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.services.AccountBalanceService;
import com.dxvalley.project.services.AccountService;
import com.dxvalley.project.services.AnnualTurnOverService;
import com.dxvalley.project.services.AssetService;
import com.dxvalley.project.services.CommodityService;
import com.dxvalley.project.services.FederationService;
import com.dxvalley.project.services.LiabilityService;
import com.dxvalley.project.services.MemberService;
import com.dxvalley.project.services.OsLoanService;
import com.dxvalley.project.services.PaidUpShareService;
import com.dxvalley.project.services.PrCooperativeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/federation")
@RestController
public class FederationExportDataController {

    @Autowired
    private final FederationService fedrationService;
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
   // private final PrCooperative prCooperative;

    private int no_of_Male_Stablishing_Member=0;
    private int no_of_Female_Stablishing_Member=0;
    private int no_of_Total_Stablishing_Member=0;


 @GetMapping("/getFederationsExport")
  List<FederationsExportData> getFederations() {
  List<FederationsExportData> federationsExportDatas = new ArrayList<FederationsExportData>();
  List<Federations> federations = fedrationService.getFederation();
   federations.stream().forEach(x->{
    FederationsExportData federationsExportData = new FederationsExportData();
    federationsExportData.setFederationName(x.getName());
    federationsExportData.setAddress(x.getAddress());
    federationsExportData.setType(x.getType());
    federationsExportData.setSector(x.getSector());
    List<Commodity> commodities=commodityService.getCommodityByFederation(x);
    List<CommodityDto> commodityDtos=new ArrayList<CommodityDto>();
    commodities.stream().forEach(c->{
        CommodityDto commodityDto= new CommodityDto();
        commodityDto.setCommodityName(c.getCommodityName());
        commodityDto.setType(c.getType());
        commodityDtos.add(commodityDto);
    });
    federationsExportData.setCommodities(commodityDtos);


    List<PrCooperative> aPrCooperatives=prCooperativeService.getPrCooperativesByFederationAndIsActive(x, true);
        federationsExportData.setNo_of_ActivePrCooperatives(aPrCooperatives.size());
        List<PrCooperative> naPrCooperatives=prCooperativeService.getPrCooperativesByFederationAndIsActive(x, false);
        federationsExportData.setNo_of_Non_ActivePrCooperatives(naPrCooperatives.size());
        List<PrCooperative> totalPrCooperatives=prCooperativeService.getPrCooperativeByFederation(x);
        federationsExportData.setTotal_No_of_PrCooperatives(totalPrCooperatives.size());
        List<Member> maleMembers=memberService.getMemberByFederationAndGender(x, "MALE");
        federationsExportData.setNo_of_Male_Individual_Member(maleMembers.size());
        List<Member> femaleMembers=memberService.getMemberByFederationAndGender(x, "FEMALE");
        federationsExportData.setNo_of_Female_Individual_Member(femaleMembers.size());
        List<Member> totalMembers=memberService.getMemberByFederation(x);
        federationsExportData.setTotal_no_of_Individual_Member(totalMembers.size());   
        List<Account> accounts=accountService.getAccountByFederation(x);
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
        federationsExportData.setAccountInfos(accountInfos);
        federationsExportData.setYearOfStablishment(x.getYearOfEstablishmnet());
        no_of_Male_Stablishing_Member=0;
        maleMembers.stream().forEach(z->{
            if(z.getIsFounder()==true){
                no_of_Male_Stablishing_Member++;
            }
        });
        federationsExportData.setNo_of_Male_Establishing_Member(no_of_Male_Stablishing_Member);
       // unionsExportData.setNo_of_Male_Stablishing_Member(no_of_Male_Stablishing_Member);

        no_of_Female_Stablishing_Member=0;
        femaleMembers.stream().forEach(a->{
            if(a.getIsFounder()==true)
            {
                no_of_Female_Stablishing_Member++;
            }
        });
        federationsExportData.setNo_of_Female_Establishing_Member(no_of_Female_Stablishing_Member);
        //unionsExportData.setNo_of_Female_Stablishing_Member(no_of_Female_Stablishing_Member);
        no_of_Total_Stablishing_Member=0;
        totalMembers.stream().forEach(b->{
            if(b.getIsFounder()==true){
                no_of_Total_Stablishing_Member++;
            }
        });
        federationsExportData.setNo_of_Total_Establishing_Member(no_of_Total_Stablishing_Member);
        federationsExportData.setShareCapitalUponEstablishmnet(x.getShareCapitalUpOnEstablishement());    
        List<AnnualTurnOver> annualTurnOvers=annualTurnOverService.getAnnualTurnOverByFederation(x);
        List<AnnualTurnOverDto> annualTurnOverDtos= new ArrayList<AnnualTurnOverDto>();
        annualTurnOvers.stream().forEach(at->{
            AnnualTurnOverDto annualTurnOverDto= new AnnualTurnOverDto();
            annualTurnOverDto.setAnnualTurnOverValue(at.getAnnualTurnOverValue());
            annualTurnOverDto.setDateGenerated(at.getDateGenerated());
            annualTurnOverDtos.add(annualTurnOverDto);
        });
        federationsExportData.setAnnualTurnOvers(annualTurnOverDtos);
        List<Asset> assets=assetService.getAssetByFederation(x);
        List<AssetDto> assetDtos= new ArrayList<AssetDto>();
        assets.stream().forEach(as->{
            AssetDto assetDto= new AssetDto();
            assetDto.setAssetName(as.getAssetName());
            assetDto.setType(as.getType());
            assetDto.setValue(as.getValue());
            assetDtos.add(assetDto);
        });
        federationsExportData.setAssets(assetDtos);
        List<Liabilty> liabilties=liabilityService.getLiabilityByFederation(x);
        final List<LiabilityDto> liabilityDtos= new ArrayList<LiabilityDto>();
        liabilties.stream().forEach(l->{
            LiabilityDto liabilityDto= new LiabilityDto();
            liabilityDto.setLiabilityValue(l.getLiabilityValue());
            liabilityDto.setDateGenerated(l.getDateGenerated());
            liabilityDtos.add(liabilityDto);
        });
        federationsExportData.setLiabilities(liabilityDtos);
        List<PaidUpShare> paidUpShares=paidUpShareService.getPaidUpShareByFederation(x);
        List<PaidUpShareDto> paidUpShareDtos= new ArrayList<PaidUpShareDto>();
        paidUpShares.stream().forEach(p->{
            PaidUpShareDto paidUpShareDto= new PaidUpShareDto();
            paidUpShareDto.setPaidUpValue(p.getPaidUpValue());
            paidUpShareDto.setDateGenerated(p.getDateGenerated());
            paidUpShareDtos.add(paidUpShareDto);
            
        });
        federationsExportData.setPaidUpShares(paidUpShareDtos);
        List<OsLoan> osLoans=osLoanService.getOsLoanByFederation(x);
        List<OsLoanDto> osLoanDtos= new ArrayList<OsLoanDto>();
        osLoans.stream().forEach(os->{
            OsLoanDto osLoanDto= new OsLoanDto();
            osLoanDto.setOsLoanValue(os.getOsLoanValue());
            osLoanDto.setDateGenerated(os.getDateGenerated());
            osLoanDtos.add(osLoanDto);
        });
        federationsExportData.setOsLoans(osLoanDtos);
        federationsExportDatas.add(federationsExportData);
        
    });
    return federationsExportDatas;
    
  }
    
}
