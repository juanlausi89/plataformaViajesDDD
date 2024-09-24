package com.jplausi.PlataformaDeViajes.contador_vehiculos.domain;

import java.util.Optional;

public interface CantidadVehiculosRepository {
    void save(CantidadVehiculos cantidad);

    Optional<CantidadVehiculos> search(CantidadVehiculosId id);
}
