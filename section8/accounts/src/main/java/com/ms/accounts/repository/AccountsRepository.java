package com.ms.accounts.repository;

import com.ms.accounts.entitty.Accounts;
import com.ms.accounts.entitty.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(Long customerId);
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
