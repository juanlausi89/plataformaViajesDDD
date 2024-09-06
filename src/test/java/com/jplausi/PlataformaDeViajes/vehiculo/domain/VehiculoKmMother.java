package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import com.jplausi.PlataformaDeViajes.shared.WordMother;

public class VehiculoKmMother {
    public static VehiculoKm create(String value) {
        return new VehiculoKm(value);
    }

    public static VehiculoKm random() {
        return create(WordMother.random());
    }
}
