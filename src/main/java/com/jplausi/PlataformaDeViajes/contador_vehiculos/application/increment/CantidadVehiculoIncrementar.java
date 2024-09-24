package com.jplausi.PlataformaDeViajes.contador_vehiculos.application.increment;

import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculos;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosId;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosRepository;
import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.UuidGenerator;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;

@Service
public class CantidadVehiculoIncrementar {
    private CantidadVehiculosRepository repository;
    private UuidGenerator uuidGenerator;

    public CantidadVehiculoIncrementar(CantidadVehiculosRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void increment(VehiculoId id) {

        CantidadVehiculosId cantidadVehiculosId = new CantidadVehiculosId(id.value());

        CantidadVehiculos counter = repository.search(cantidadVehiculosId).orElseGet(() -> CantidadVehiculos.initialize(uuidGenerator.generate()));

        if (!counter.hasIncremented(id)) {
            counter.increment(id);

            repository.save(counter);
        }
    }
}
