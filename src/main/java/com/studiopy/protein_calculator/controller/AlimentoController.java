package com.studiopy.protein_calculator.controller;

import com.studiopy.protein_calculator.model.*;
import com.studiopy.protein_calculator.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
@CrossOrigin(origins = "*")
public class AlimentoController {

    private final AlimentoService alimentoService;

    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @GetMapping
    public List<Alimento> buscar(@RequestParam String search) {
        return alimentoService.buscar(search);
    }
}
