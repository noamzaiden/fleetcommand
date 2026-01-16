package com.noam.fleetcommand.assets;

import com.noam.fleetcommand.assets.dto.AssetRequestDto;
import com.noam.fleetcommand.assets.dto.AssetResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public List<AssetResponseDto> getAllAssets() {
        return assetService.getAllAssets()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetResponseDto> getAssetById(@PathVariable Long id) {
        Optional<Asset> asset = assetService.getAssetById(id);

        if (asset.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(toResponseDto(asset.get()));
    }

    @PostMapping
    public ResponseEntity<AssetResponseDto> createAsset(@RequestBody AssetRequestDto request) {
        Asset createdAsset = assetService.createAsset(toEntity(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDto(createdAsset));
    }


    private AssetResponseDto toResponseDto(Asset asset) {
        return new AssetResponseDto(asset.getId(), asset.getName(), asset.getTrackingEnabled());
    }

    private Asset toEntity(AssetRequestDto request) {
        Asset asset = new Asset();
        asset.setName(request.getName());
        asset.setTrackingEnabled(request.getTrackingEnabled());
        return asset;
    }

}
