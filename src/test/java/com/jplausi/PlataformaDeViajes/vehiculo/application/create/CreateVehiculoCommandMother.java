package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoIdMother;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKm;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKmMother;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatente;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatenteMother;

public class CreateVehiculoCommandMother {

    public static CreateVehiculoCommand create(VehiculoId id, VehiculoPatente patente, VehiculoKm km){
        return new CreateVehiculoCommand(id.value(),patente.value(),km.value());
    }

    public static CreateVehiculoCommand random(){
        return create(VehiculoIdMother.random(),VehiculoPatenteMother.random(),VehiculoKmMother.random());
    }
    
}
