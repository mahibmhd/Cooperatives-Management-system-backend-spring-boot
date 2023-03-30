package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Asset;

public interface AssetRepository extends JpaRepository <Asset, Long> {
    Asset findAssetByAssetId(Long assetId);
    Asset findAssetByAssetName(String assetName);
     
}
