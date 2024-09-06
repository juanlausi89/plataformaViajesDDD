package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import com.jplausi.PlataformaDeViajes.apps.vehiculo.CreateVehiculoRequest;

public class VehiculoMother {
    
    public static Vehiculo create(VehiculoId id, VehiculoPatente patente, VehiculoKm km) {
        return new Vehiculo(id, patente, km);
    }

    public static Vehiculo fromRequest(CreateVehiculoRequest request){
        return create(
            VehiculoIdMother.create(request.getId()), 
            VehiculoPatenteMother.create(request.getPatente()), 
            VehiculoKmMother.create(request.getKm())
            );
    }

    public static Vehiculo random() {
        return create(VehiculoIdMother.random(), VehiculoPatenteMother.random(), VehiculoKmMother.random());
    }
}
