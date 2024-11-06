package kte.projekt.ms_bmi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmiDTO {
    private int height;
    private int weight;

    private AccountDTO account;
}
