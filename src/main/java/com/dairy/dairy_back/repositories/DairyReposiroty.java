package com.dairy.dairy_back.repositories;

import com.dairy.dairy_back.model.Dairy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DairyReposiroty extends JpaRepository<Dairy, Long> {

}
