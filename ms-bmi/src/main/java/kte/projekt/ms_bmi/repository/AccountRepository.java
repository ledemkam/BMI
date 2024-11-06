package kte.projekt.ms_bmi.repository;

import kte.projekt.ms_bmi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

 Optional<Account> findByEmail(String email);
}
