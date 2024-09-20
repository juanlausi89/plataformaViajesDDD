package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import java.util.Objects;

import com.jplausi.PlataformaDeViajes.shared.domain.AggregateRoot;
import com.jplausi.PlataformaDeViajes.shared.domain.vehiculo.VehiculoCreatedDomainEvent;

public class Vehiculo extends AggregateRoot {

    private VehiculoId id;
    private VehiculoPatente patente;
    private VehiculoKm km;


    public Vehiculo(VehiculoId id, VehiculoPatente patente, VehiculoKm km) {
        this.id = id;
        this.patente = patente;
        this.km = km;
    }

    private Vehiculo() {
        id       = null;
        patente     = null;
        km = null;
    }

    public static Vehiculo create(VehiculoId id, VehiculoPatente patente, VehiculoKm km) {
        Vehiculo vehiculo = new Vehiculo(id, patente, km);

        vehiculo.record(new VehiculoCreatedDomainEvent(id.value(), patente.value(), km.value()));

        return vehiculo;
    }

    public VehiculoId getId() {
        return this.id;
    }

    public void setId(VehiculoId id) {
        this.id = id;
    }

    public VehiculoPatente getPatente() {
        return this.patente;
    }

    public void setPatente(VehiculoPatente patente) {
        this.patente = patente;
    }

    public VehiculoKm getKm() {
        return this.km;
    }

    public void setKm(VehiculoKm km) {
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
