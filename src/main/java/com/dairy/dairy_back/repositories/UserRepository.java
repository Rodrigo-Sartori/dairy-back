package com.dairy.dairy_back.repositories;

import com.dairy.dairy_back.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Person,Long> {

    Optional<Person> findByEmail(String email);
}
