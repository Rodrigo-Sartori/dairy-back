package com.dairy.dairy_back.dto;


import com.dairy.dairy_back.model.Dairy;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class DairyDTO {

    @NotEmpty
    private String content;
    private Long id;
    private LocalDateTime createdAt;
    @NotEmpty
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dairyDate;

    public static DairyDTO toDto(Dairy dairy) {
        return DairyDTO.builder()
                .id(dairy.getId())
                .content(dairy.getContent())
                .createdAt(dairy.getCreatedAt())
                .dairyDate(dairy.getDairyDate())
                .build();
    }

    public static Dairy toModel(DairyDTO dto) {
        return new Dairy(dto.content, dto.dairyDate);
    }
}
