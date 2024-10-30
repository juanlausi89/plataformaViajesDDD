package com.jplausi.PlataformaDeViajes.contador_vehiculos.application.find;

import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.Query;

public final class FindContadorDeVehiculoQuery implements Query {
    
    private String id;

    public FindContadorDeVehiculoQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }

}
