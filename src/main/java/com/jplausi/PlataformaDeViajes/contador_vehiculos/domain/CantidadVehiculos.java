package com.jplausi.PlataformaDeViajes.contador_vehiculos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;

public final class CantidadVehiculos {
    private CantidadVehiculosId    id;
    private CantidadVehiculosTotal total;
    private List<VehiculoId> existenVehiculos;

    public CantidadVehiculos(CantidadVehiculosId id, CantidadVehiculosTotal total, List<VehiculoId> existenVehiculos) {
        this.id = id;
        this.total = total;
        this.existenVehiculos = existenVehiculos;
    }

    private CantidadVehiculos() {
        this.id = null;
        this.total = null;
        this.existenVehiculos = null;
    }

    public static CantidadVehiculos initialize(String id) {
        return new CantidadVehiculos(new CantidadVehiculosId(id), CantidadVehiculosTotal.initialize(), new ArrayList<>());
    }

    public CantidadVehiculosId getId() {
        return id;
    }

    public CantidadVehiculosTotal getTotal() {
        return total;
    }

    public List<VehiculoId> getExistenVehiculos() {
        return existenVehiculos;
    }

    public boolean hasIncremented(VehiculoId id) {
        return existenVehiculos.contains(id);
    }

    public void increment(VehiculoId id) {
        total = total.increment();
        existenVehiculos.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CantidadVehiculos that = (CantidadVehiculos) o;
        return id.equals(that.id) &&
               total.equals(that.total) &&
               existenVehiculos.equals(that.existenVehiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existenVehiculos);
    } 
}
