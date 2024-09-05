package com.jplausi.PlataformaDeViajes.vehiculo.application;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.jplausi.PlataformaDeViajes.apps.vehiculo.CreateVehiculoRequest;
import com.jplausi.PlataformaDeViajes.vehiculo.application.create.VehiculoCreator;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKm;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatente;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

final class VehiculoCreatorTest {

    @Test
    void guardar_vehiculo_valido(){
        VehiculoRepository repository = mock(VehiculoRepository.class);
        VehiculoCreator creator = new VehiculoCreator(repository);

        CreateVehiculoRequest request = new CreateVehiculoRequest("decf33ca-81a7-419f-a07a-74f214e928e5", "some-patente","some-km");

        Vehiculo vehiculo = new Vehiculo(
            new VehiculoId(request.getId()), 
            new VehiculoPatente(request.getPatente()), 
            new VehiculoKm(request.getKm())
            );

        creator.create(request);

        verify(repository,atLeastOnce()).save(vehiculo);
    }
    
}
