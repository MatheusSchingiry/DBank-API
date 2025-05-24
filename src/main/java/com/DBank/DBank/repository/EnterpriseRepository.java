package com.DBank.DBank.repository;

import com.DBank.DBank.model.EnterpriseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseModel, String> {
    Optional<EnterpriseModel> findByEmail(String email);
}
