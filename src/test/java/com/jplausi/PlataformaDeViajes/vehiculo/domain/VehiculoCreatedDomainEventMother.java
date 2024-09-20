package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import com.jplausi.PlataformaDeViajes.shared.domain.vehiculo.VehiculoCreatedDomainEvent;

public class VehiculoCreatedDomainEventMother {
    public static VehiculoCreatedDomainEvent create(VehiculoId id, VehiculoPatente patente, VehiculoKm km) {
        return new VehiculoCreatedDomainEvent(id.value(), patente.value(), km.value());
    }

    public static VehiculoCreatedDomainEvent fromCourse(Vehiculo vehiculo) {
        return create(vehiculo.getId(), vehiculo.getPatente(), vehiculo.getKm());
    }

    public static VehiculoCreatedDomainEvent random() {
        return create(VehiculoIdMother.random(), VehiculoPatenteMother.random(), VehiculoKmMother.random());
    }
}
