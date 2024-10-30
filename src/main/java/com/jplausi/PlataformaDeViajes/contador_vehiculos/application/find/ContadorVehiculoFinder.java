package com.jplausi.PlataformaDeViajes.contador_vehiculos.application.find;

import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculos;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosId;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosNotInitialized;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosRepository;
import com.jplausi.PlataformaDeViajes.shared.domain.Service;

@Service
public class ContadorVehiculoFinder {
    private CantidadVehiculosRepository repository;

    public ContadorVehiculoFinder(CantidadVehiculosRepository repository) {
        this.repository = repository;
    }

    public ContadorDeVehiculoResponse find(CantidadVehiculosId id) {
        CantidadVehiculos cantidadVehiculo = repository.search(id).orElseGet(() -> {
            throw new CantidadVehiculosNotInitialized();
        });

        return new ContadorDeVehiculoResponse(cantidadVehiculo.getTotal().value());
    }
}
