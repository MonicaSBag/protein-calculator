package com.studiopy.protein_calculator.service;

import com.studiopy.protein_calculator.model.Alimento;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlimentoService {

    private final List<Alimento> alimentos = new ArrayList<>();

    @PostConstruct
    public void cargarExcel() {
        try {
            InputStream is = getClass().getResourceAsStream("/alimentos.xlsx");
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // saltar encabezado

                Cell nombreCell = row.getCell(0);
                Cell proteinaCell = row.getCell(1);

                if (nombreCell == null || proteinaCell == null) continue;

                String nombre = nombreCell.getStringCellValue();
                double proteina = proteinaCell.getNumericCellValue();

                alimentos.add(new Alimento(nombre, proteina));
            }
            System.out.println("Cargando Excel... filas encontradas: " + sheet.getLastRowNum());
            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo el Excel de alimentos", e);
        }
    }

    public List<Alimento> buscar(String query) {
        String q = query.toLowerCase();

        return alimentos.stream()
                .filter(a -> a.getNombre().toLowerCase().contains(q))
                .limit(10)
                .collect(Collectors.toList());
    }
}
