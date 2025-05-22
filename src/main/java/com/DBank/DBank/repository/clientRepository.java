package com.DBank.DBank.repository;

import com.DBank.DBank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface clientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByEmail(String email);
}
