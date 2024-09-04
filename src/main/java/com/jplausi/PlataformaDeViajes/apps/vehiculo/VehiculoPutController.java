package com.jplausi.PlataformaDeViajes.apps.vehiculo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jplausi.PlataformaDeViajes.vehiculo.application.create.VehiculoCreator;

@RestController
public final class VehiculoPutController {

    private VehiculoCreator creator;

    public VehiculoPutController(VehiculoCreator creator){
        this.creator = creator;
    }

    @PutMapping(value = "/vehiculo/{id}")
    public ResponseEntity<String> create(
        @PathVariable String id,
        @RequestBody Request request
    ){
        creator.create(new CreateVehiculoRequest(id, request.getPatente(), request.getKm()));
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}

final class Request {
    private String patente;
    private String km;

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getKm() {
        return this.km;
    }

    public void setKm(String km) {
        this.km = km;
    }
    
    
}
