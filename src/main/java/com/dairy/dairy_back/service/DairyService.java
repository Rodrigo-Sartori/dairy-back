package com.dairy.dairy_back.service;

import com.dairy.dairy_back.dto.DairyDTO;
import com.dairy.dairy_back.repositories.DairyReposiroty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DairyService {

    private final DairyReposiroty repository;

    public List<DairyDTO> getDairies() {
        log.info("[DAIRY-SERVICE] [GETDAIRIES] service init");
        var dairies = repository.findAll();
        return dairies.stream().map(DairyDTO::toDto).toList();
    }

    public DairyDTO saveDairy(DairyDTO dto) {
        log.info("[DAIRY-SERVICE] [SAVEDAIRY]service init");
        var savedDairy = repository.save(DairyDTO.toModel(dto));
        return DairyDTO.toDto(savedDairy);
    }

}
