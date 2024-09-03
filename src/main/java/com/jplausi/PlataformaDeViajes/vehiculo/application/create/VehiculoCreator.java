package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

@Service
public class VehiculoCreator {

    private VehiculoRepository repository;


    public VehiculoCreator(VehiculoRepository repository) {
        this.repository = repository;
    }


    public void create(String id, String patente, String km){
        Vehiculo vehiculo = new Vehiculo(id,patente, km);
        repository.save(vehiculo);
    }
    
}
