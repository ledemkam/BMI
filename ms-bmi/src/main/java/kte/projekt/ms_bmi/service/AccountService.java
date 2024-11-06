package kte.projekt.ms_bmi.service;

import kte.projekt.ms_bmi.entity.Account;
import kte.projekt.ms_bmi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {

   final  AccountRepository accountRepository;

    public Account createAccount(Account account) {
        if (!account.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email is invalid");
        }
        Optional<Account> exinstingAccount = accountRepository.findByEmail(account.getEmail());
        if (exinstingAccount.isPresent()) {
            throw new IllegalArgumentException("Account with this email already exists");
        } else {
            account.setCreatedAt(LocalDateTime.now());
            return accountRepository.save(account);
        }
    }
}
