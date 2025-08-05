package com.dairy.dairy_back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dairy {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "dairy_date")
    private LocalDate dairyDate;
    @ManyToOne
    private Person person;

    public Dairy(String content, LocalDate dairyDate) {
        this.content = content;
        this.dairyDate = dairyDate;
    }
}
