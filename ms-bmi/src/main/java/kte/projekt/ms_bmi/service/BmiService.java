package kte.projekt.ms_bmi.service;

import kte.projekt.ms_bmi.entity.Account;
import kte.projekt.ms_bmi.entity.Bmi;
import kte.projekt.ms_bmi.repository.BmiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class BmiService {

      final AccountService accountService;
      final BmiRepository bmiRepository;

        public double calculateBmi(Bmi bmi) {

            Account account = bmi.getAccount();
            account = accountService.createAccount(account);
            bmi.setAccount(account);
            double result =  bmiFromParams(bmi);
            bmi.setCreatedAt(LocalDateTime.now());
            bmiRepository.save(bmi);
            return result;
        }

        public Set<Bmi> getAllBmi() {
            Set<Bmi> bmiSet = new HashSet<>();
            bmiRepository.findAll().forEach(bmiSet::add);
            return bmiSet;
        }

    private double bmiFromParams(Bmi bmi) {
       return bmi.getWeight() / Math.pow((double)bmi.getHeight()/100, 2);
    }
}
