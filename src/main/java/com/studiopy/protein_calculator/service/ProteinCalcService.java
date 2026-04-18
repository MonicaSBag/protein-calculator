package com.studiopy.protein_calculator.service;

import org.springframework.stereotype.Service;

@Service
public class ProteinCalcService {
    public double calculate(double proteinPer100gr, double grams){
        return (proteinPer100gr * grams) / 100;
    }
}
