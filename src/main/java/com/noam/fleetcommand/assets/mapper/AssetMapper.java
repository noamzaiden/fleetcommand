package com.noam.fleetcommand.assets.mapper;

import com.noam.fleetcommand.assets.Asset;
import com.noam.fleetcommand.assets.dto.AssetRequestDto;
import com.noam.fleetcommand.assets.dto.AssetResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AssetMapper {

    public Asset toEntity(AssetRequestDto request) {
        Asset asset = new Asset();
        asset.setName(request.getName());
        asset.setTrackingEnabled(request.getTrackingEnabled());
        return asset;
    }

    public AssetResponseDto toResponseDto(Asset asset) {
        return new AssetResponseDto(asset.getId(), asset.getName(), asset.getTrackingEnabled());
    }
}
