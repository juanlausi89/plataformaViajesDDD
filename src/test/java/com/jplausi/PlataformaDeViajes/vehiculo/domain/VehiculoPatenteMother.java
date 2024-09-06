package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import com.jplausi.PlataformaDeViajes.shared.WordMother;

public class VehiculoPatenteMother {
    public static VehiculoPatente create(String value) {
        return new VehiculoPatente(value);
    }

    public static VehiculoPatente random() {
        return create(WordMother.random());
    }
}
