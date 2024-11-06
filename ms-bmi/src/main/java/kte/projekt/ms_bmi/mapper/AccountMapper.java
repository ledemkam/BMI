package kte.projekt.ms_bmi.mapper;

import kte.projekt.ms_bmi.dto.AccountDTO;
import kte.projekt.ms_bmi.entity.Account;
import org.springframework.stereotype.Component;

@Component // Spring will create a bean of this class, so we can inject it into other classes
public class AccountMapper {

        public Account dtoToEntity(AccountDTO input) {
            Account output = new Account();
            output.setEmail(input.getEmail());
            output.setName(input.getName());
            return output;
        }

        public AccountDTO entityToDto(Account input) {
            AccountDTO output = new AccountDTO();
            output.setEmail(input.getEmail());
            output.setName(input.getName());
            return output;
        }

}