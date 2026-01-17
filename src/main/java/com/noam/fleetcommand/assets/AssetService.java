package com.noam.fleetcommand.assets;

import com.noam.fleetcommand.assets.dto.AssetRequestDto;
import com.noam.fleetcommand.assets.dto.AssetResponseDto;
import com.noam.fleetcommand.assets.mapper.AssetMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    public AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    public List<AssetResponseDto> getAllAssets() {
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toResponseDto)
                .toList();
    }

    public AssetResponseDto getAssetById(Long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found: " + id));

        return assetMapper.toResponseDto(asset);
    }

    public AssetResponseDto createAsset(AssetRequestDto request) {
        Asset asset = assetMapper.toEntity(request);
        Asset saved = assetRepository.save(asset);
        return assetMapper.toResponseDto(saved);
    }
}
