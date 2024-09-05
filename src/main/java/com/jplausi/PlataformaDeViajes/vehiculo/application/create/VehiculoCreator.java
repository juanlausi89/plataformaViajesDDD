package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import com.jplausi.PlataformaDeViajes.apps.vehiculo.CreateVehiculoRequest;
import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKm;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatente;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

@Service
public class VehiculoCreator {

    private VehiculoRepository repository;


    public VehiculoCreator(VehiculoRepository repository) {
        this.repository = repository;
    }


    public void create(CreateVehiculoRequest request){
        
        Vehiculo vehiculo = new Vehiculo(
            new VehiculoId(request.getId()),
            new VehiculoPatente(request.getPatente()), 
            new VehiculoKm(request.getKm())
        );

        repository.save(vehiculo);
    }
    
}
