package com.jplausi.PlataformaDeViajes.contador_vehiculos.application.find;

import java.util.Objects;

import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.Response;

public class ContadorDeVehiculoResponse implements Response {
    private Integer total;

    public ContadorDeVehiculoResponse(Integer total) {
        this.total = total;
    }

    public Integer total() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContadorDeVehiculoResponse that = (ContadorDeVehiculoResponse) o;
        return total.equals(that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    } 
}
