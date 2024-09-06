package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.jplausi.PlataformaDeViajes.apps.vehiculo.CreateVehiculoRequest;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoMother;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

final class VehiculoCreatorTest {

    @Test
    void guardar_vehiculo_valido(){
        VehiculoRepository repository = mock(VehiculoRepository.class);
        VehiculoCreator creator = new VehiculoCreator(repository);

        CreateVehiculoRequest request = CreateVehiculoRequestMother.random();

        Vehiculo vehiculo = VehiculoMother.fromRequest(request);

        creator.create(request);

        verify(repository,atLeastOnce()).save(vehiculo);
    }
    
}
