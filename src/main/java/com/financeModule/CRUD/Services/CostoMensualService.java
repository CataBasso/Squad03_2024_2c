package com.financeModule.CRUD.Services;


import com.financeModule.CRUD.model.CostoMensualDeActividad;
import com.financeModule.CRUD.repository.CostoMensualRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CostoMensualService {
    @Autowired
    private CostoMensualRepo costoMensualRepo;


    public ResponseEntity<CostoMensualDeActividad> addCost(CostoMensualDeActividad costo) {
        CostoMensualDeActividad costoObj = costoMensualRepo.save(costo);
        return new ResponseEntity<>(costoObj, HttpStatus.CREATED);
    }

    public ResponseEntity<List<CostoMensualDeActividad>> addCosts(List<CostoMensualDeActividad> costos) {
        List<CostoMensualDeActividad> savedCostos = new ArrayList<>();

        for (CostoMensualDeActividad costo : costos) {
            CostoMensualDeActividad savedCosto = costoMensualRepo.save(costo);
            savedCostos.add(savedCosto);
        }

        return new ResponseEntity<>(savedCostos, HttpStatus.CREATED);
    }


    public ResponseEntity<List<CostoMensualDeActividad>> getCostos() {
        List<CostoMensualDeActividad> CostosList = new ArrayList<>();
        CostosList.addAll(costoMensualRepo.findAll());

        if (CostosList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(CostosList, HttpStatus.OK);
    }

    public void setCostoMensualRepo(CostoMensualRepo costoMensualRepo) {
        this.costoMensualRepo = costoMensualRepo;
    }
}
