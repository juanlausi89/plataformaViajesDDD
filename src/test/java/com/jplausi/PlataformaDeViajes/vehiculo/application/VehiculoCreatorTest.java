package com.jplausi.PlataformaDeViajes.vehiculo.application;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.jplausi.PlataformaDeViajes.apps.vehiculo.CreateVehiculoRequest;
import com.jplausi.PlataformaDeViajes.vehiculo.application.create.VehiculoCreator;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

final class VehiculoCreatorTest {

    @Test
    void guardar_vehiculo_valido(){
        VehiculoRepository repository = mock(VehiculoRepository.class);
        VehiculoCreator creator = new VehiculoCreator(repository);

        Vehiculo vehiculo = new Vehiculo("some-id", "some-patente","some-km");

        creator.create(new CreateVehiculoRequest(vehiculo.getId(), vehiculo.getPatente(), vehiculo.getKm()));

        verify(repository,atLeastOnce()).save(vehiculo);
    }
    
}
