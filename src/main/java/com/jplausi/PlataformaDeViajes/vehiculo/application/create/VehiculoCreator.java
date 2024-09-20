package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import com.jplausi.PlataformaDeViajes.apps.vehiculo.CreateVehiculoRequest;
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


    public void create(CreateVehiculoRequest request){

        VehiculoId id = new VehiculoId(request.getId());
        VehiculoPatente patente = new VehiculoPatente(request.getPatente());
        VehiculoKm km = new VehiculoKm(request.getId());
        
        Vehiculo vehiculo = Vehiculo.create(id, patente, km);

        repository.save(vehiculo);
        eventBus.publish(vehiculo.pullDomainEvents());
    }
    
}
