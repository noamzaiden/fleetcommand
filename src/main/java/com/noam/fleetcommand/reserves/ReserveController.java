package com.noam.fleetcommand.reserves;

import com.noam.fleetcommand.reserves.dto.ReserveRequestDto;
import com.noam.fleetcommand.reserves.dto.ReserveResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/reserves")
public class ReserveController {

    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @GetMapping
    public List<ReserveResponseDto> getAllReserves() {
        return reserveService.getAllReserves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReserveResponseDto> getReserveById(@PathVariable Long id) {
        return ResponseEntity.ok(reserveService.getReserveById(id));
    }

    @PostMapping
    public ResponseEntity<ReserveResponseDto> createReserve(@Valid @RequestBody ReserveRequestDto request) {
        ReserveResponseDto created = reserveService.createReserve(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
