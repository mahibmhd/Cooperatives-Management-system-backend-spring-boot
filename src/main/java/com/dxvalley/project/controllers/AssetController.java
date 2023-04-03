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

import com.dxvalley.project.models.Asset;
import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.services.AssetService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/asset")

public class AssetController {

    @Autowired
    private final AssetService assetService;

    @GetMapping("/getAssets")
    List<Asset> getAsset() {
    return this.assetService.getAssets();
  }

  @GetMapping("/{assetId}")
  Asset getAsset(@PathVariable Long assetId) {
    return assetService.getAssetById(assetId);
  }

  @PostMapping("/add")
  public ResponseEntity<CreateResponse> addSector (@RequestBody Asset asset) {
    Asset assetToBeChecked= assetService.getAssetByAssetName(asset.getAssetName());
    if(assetToBeChecked!=null)
    {
        CreateResponse response = new CreateResponse("error","existing asset name");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else
    {
        assetService.addAsset(asset);
        CreateResponse response = new CreateResponse("success","Asset created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

  }

  @PutMapping("/edit/{assetId}")
  Asset editAsset(@RequestBody Asset tempAsset, @PathVariable Long assetId) {
    Asset asset = this.assetService.getAssetById(assetId);
    asset.setAssetName(tempAsset.getAssetName());
    asset.setValue(tempAsset.getValue());
    asset.setType(tempAsset.getType());
    asset.setPrCooperative(tempAsset.getPrCooperative());
    asset.setUnion(tempAsset.getUnion());
    return assetService.editAsset(asset);
  }
    
}
