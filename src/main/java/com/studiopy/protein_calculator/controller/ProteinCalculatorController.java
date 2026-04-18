package com.studiopy.protein_calculator.controller;

import com.studiopy.protein_calculator.model.ProteinCalc;
import com.studiopy.protein_calculator.service.ProteinCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class ProteinCalculatorController {

    @Autowired
    private ProteinCalcService calculatorService;

    @PostMapping("/protein")
    public double calculateProtein(@RequestBody ProteinCalc request) {
        return calculatorService.calculate(
                request.getProteinPer100g(),
                request.getGrams());
    }
}
