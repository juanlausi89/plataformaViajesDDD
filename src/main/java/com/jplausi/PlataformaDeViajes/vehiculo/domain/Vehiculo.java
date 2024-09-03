package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import java.util.Objects;

public class Vehiculo {

    private String id;
    private String patente;
    private String km;


    public Vehiculo(String id, String patente, String km) {
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
        Vehiculo vehiculo = (Vehiculo) o;
        return id.equals(vehiculo.id) &&
               patente.equals(vehiculo.patente) &&
               km.equals(vehiculo.km);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patente, km);
    }


    
}
