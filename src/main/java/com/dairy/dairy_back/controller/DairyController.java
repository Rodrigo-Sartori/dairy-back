package com.dairy.dairy_back.controller;

import com.dairy.dairy_back.dto.DairyDTO;
import com.dairy.dairy_back.service.DairyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dairy")
@Slf4j
@RequiredArgsConstructor
public class DairyController {

    private final DairyService service;

    @GetMapping
    public ResponseEntity<List<DairyDTO>> getDairy() {
        return ResponseEntity.ok(service.getDairies());
    }

    @PostMapping
    public ResponseEntity<DairyDTO> saveDairy(@RequestBody DairyDTO newDairy) {
        return ResponseEntity.ok(service.saveDairy(newDairy));
    }
}
