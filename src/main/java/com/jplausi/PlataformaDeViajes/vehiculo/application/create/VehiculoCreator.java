package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.EventBus;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKm;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatente;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

@Service
public final class VehiculoCreator {

    private final VehiculoRepository repository;
    private final EventBus eventBus;


    public VehiculoCreator(VehiculoRepository repository,EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }


    public void create(VehiculoId id,VehiculoPatente patente,VehiculoKm km  ){
        
        Vehiculo vehiculo = Vehiculo.create(id, patente, km);

        repository.save(vehiculo);
        eventBus.publish(vehiculo.pullDomainEvents());
    }
    
}
