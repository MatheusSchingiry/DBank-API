package com.DBank.DBank.repository;

import com.DBank.DBank.model.EnterpriseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseModel, UUID> {
    Optional<EnterpriseModel> findByEmail(String email);
}
