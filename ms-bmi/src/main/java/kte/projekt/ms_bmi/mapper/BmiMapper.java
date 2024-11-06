package kte.projekt.ms_bmi.mapper;

import kte.projekt.ms_bmi.dto.BmiDTO;
import kte.projekt.ms_bmi.entity.Bmi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BmiMapper {

    final AccountMapper accountMapper;

    public Bmi dtoToEntity(BmiDTO input) {
        Bmi output = new Bmi();
        output.setWeight(input.getWeight());
        output.setHeight(input.getHeight());
        output.setAccount(accountMapper.dtoToEntity(input.getAccount()));
        return output;
    }

    public BmiDTO entityToDto(Bmi input) {
        BmiDTO output = new BmiDTO();
        output.setWeight(input.getWeight());
        output.setHeight(input.getHeight());
        output.setAccount(accountMapper.entityToDto(input.getAccount()));
        return output;
    }
}
