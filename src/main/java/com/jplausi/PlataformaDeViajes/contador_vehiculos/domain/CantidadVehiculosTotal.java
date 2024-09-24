package com.jplausi.PlataformaDeViajes.contador_vehiculos.domain;

import com.jplausi.PlataformaDeViajes.shared.domain.IntValueObject;

public class CantidadVehiculosTotal extends IntValueObject {
    public CantidadVehiculosTotal(Integer value) {
        super(value);
    }

    public CantidadVehiculosTotal() {
        super(null);
    }

    public static CantidadVehiculosTotal initialize() {
        return new CantidadVehiculosTotal(0);
    }

    public CantidadVehiculosTotal increment() {
        return new CantidadVehiculosTotal(value() + 1);
    }
}
