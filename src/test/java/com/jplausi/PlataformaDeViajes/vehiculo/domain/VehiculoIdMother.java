package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import com.jplausi.PlataformaDeViajes.shared.UuidMother;

public class VehiculoIdMother {
     public static VehiculoId create(String value) {
        return new VehiculoId(value);
    }

    public static VehiculoId random() {
        return create(UuidMother.random());
    }
}
