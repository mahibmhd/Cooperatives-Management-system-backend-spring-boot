package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.services.PaidUpShareService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/paidUpShare")

public class PaidUpShareController {
    @Autowired
    private final PaidUpShareService paidUpShareService;
    
    @GetMapping("/getPaidUpShares")
    List<PaidUpShare> getPaidUpShare () {
    return this.paidUpShareService.getPaidUpShare();
  }

  @GetMapping("/{paidUpShareId}")
  PaidUpShare getPaidUpShare(@PathVariable Long paidUpShareId) {
    return paidUpShareService.getPaidUpShareById(paidUpShareId);
  }

  @PostMapping("/add")
  public ResponseEntity<CreateResponse> addCommodity(@RequestBody PaidUpShare paidUpShare) {
      paidUpShareService.addPaidUpShare(paidUpShare);
      CreateResponse response = new CreateResponse("success", "paidUpShare created successfully");
      return new ResponseEntity<>(response, HttpStatus.OK);

  }

  @PutMapping("/edit/{paidUpShareId}")
  PaidUpShare editSector(@RequestBody PaidUpShare tempPaidUpShare, @PathVariable Long paidUpShareId) {
    PaidUpShare paidUpShare = this.paidUpShareService.getPaidUpShareById(paidUpShareId);
    paidUpShare.setPaidUpValue(tempPaidUpShare.getPaidUpValue());
    paidUpShare.setDateGenerated(tempPaidUpShare.getDateGenerated());
    paidUpShare.setPrCooperative(tempPaidUpShare.getPrCooperative());
    paidUpShare.setUnion(tempPaidUpShare.getUnion());
    return paidUpShareService.editPaidUpShare(paidUpShare);
  }

    
}
