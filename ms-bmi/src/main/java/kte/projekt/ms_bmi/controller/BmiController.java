package kte.projekt.ms_bmi.controller;

import kte.projekt.ms_bmi.dto.BmiDTO;
import kte.projekt.ms_bmi.entity.Bmi;
import kte.projekt.ms_bmi.mapper.BmiMapper;
import kte.projekt.ms_bmi.service.BmiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/bmi")
public class BmiController {

    final BmiMapper bmiMapper;
    final BmiService bmiService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Double> calculateBmi(@RequestBody BmiDTO bmiDTO) {
       Bmi bmi = bmiMapper.dtoToEntity(bmiDTO);
       double result = bmiService.calculateBmi(bmi);
       return Map.of("bmi", result);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<BmiDTO> getAllBmi() {
        Set<Bmi> result = bmiService.getAllBmi();
        final Set<BmiDTO> bmiSet = new HashSet<>();
        for(Bmi bmi : result) {
            bmiSet.add(bmiMapper.entityToDto(bmi));
        }
        return bmiSet;
    }



}
