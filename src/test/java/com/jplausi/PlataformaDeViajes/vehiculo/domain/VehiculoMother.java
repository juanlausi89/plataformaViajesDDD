package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import com.jplausi.PlataformaDeViajes.vehiculo.application.create.CreateVehiculoCommand;

public class VehiculoMother {
    
    public static Vehiculo create(VehiculoId id, VehiculoPatente patente, VehiculoKm km) {
        return new Vehiculo(id, patente, km);
    }

    public static Vehiculo fromRequest(CreateVehiculoCommand command){
        return create(
            VehiculoIdMother.create(command.id()), 
            VehiculoPatenteMother.create(command.patente()), 
            VehiculoKmMother.create(command.km())
            );
    }

    public static Vehiculo random() {
        return create(VehiculoIdMother.random(), VehiculoPatenteMother.random(), VehiculoKmMother.random());
    }
}
