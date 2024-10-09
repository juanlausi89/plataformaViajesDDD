package com.jplausi.PlataformaDeViajes.contador_vehiculos.application.increment;

import org.springframework.context.event.EventListener;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEventSubscriber;
import com.jplausi.PlataformaDeViajes.shared.domain.vehiculo.VehiculoCreatedDomainEvent;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;

@Service
@DomainEventSubscriber({VehiculoCreatedDomainEvent.class})
public final class ContadorDeVehiculos {
     private final CantidadVehiculoIncrementar incrementer;

    public ContadorDeVehiculos(CantidadVehiculoIncrementar incrementer) {
        this.incrementer = incrementer;
    }

    //@EventListener
    public void on(VehiculoCreatedDomainEvent event) {
        VehiculoId vehiculoId = new VehiculoId(event.aggregateId());

        incrementer.increment(vehiculoId);
    }
}
