package com.DBank.DBank.repository;

import com.DBank.DBank.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, String> {
    Optional<ClientModel> findByEmail(String email);
}
