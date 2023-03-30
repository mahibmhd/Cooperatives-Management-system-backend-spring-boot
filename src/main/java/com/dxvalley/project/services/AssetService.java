package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Asset;

public interface AssetService {
    Asset addAsset (Asset asset);
    Asset editAsset (Asset asset);
    List<Asset> getAssets ();
    Asset getAssetById(Long assetId);
    Asset getAssetByAssetName(String assetName);
    void deleteAsset( Long assetId);
    
    
}
