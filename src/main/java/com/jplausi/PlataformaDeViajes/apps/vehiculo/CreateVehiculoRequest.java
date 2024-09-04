package com.jplausi.PlataformaDeViajes.apps.vehiculo;

import java.util.Objects;


public final class CreateVehiculoRequest {

    private String id;
    private String patente;
    private String km;


    public CreateVehiculoRequest(String id, String patente, String km) {
        this.id = id;
        this.patente = patente;
        this.km = km;
    }
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateVehiculoRequest createVehiculoRequest = (CreateVehiculoRequest) o;
        return id.equals(createVehiculoRequest.id) &&
               patente.equals(createVehiculoRequest.patente) &&
               km.equals(createVehiculoRequest.km);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patente, km);
    }
    
    
}
