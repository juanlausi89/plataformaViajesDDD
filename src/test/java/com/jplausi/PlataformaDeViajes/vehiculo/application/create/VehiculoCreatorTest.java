package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jplausi.PlataformaDeViajes.apps.vehiculo.CreateVehiculoRequest;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;
import com.jplausi.PlataformaDeViajes.shared.domain.vehiculo.VehiculoCreatedDomainEvent;
import com.jplausi.PlataformaDeViajes.vehiculo.VehiculoModuleUnitTestCase;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoCreatedDomainEventMother;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoMother;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

final class VehiculoCreatorTest extends VehiculoModuleUnitTestCase {

    private VehiculoCreator creator;


    @BeforeEach
    protected void setUp() {
        super.setUp();
        creator = new VehiculoCreator(repository,eventBus);
    }

    //Enfoque con herencia
    @Test
    void guardar_vehiculo_valido(){

        CreateVehiculoRequest request = CreateVehiculoRequestMother.random();

        Vehiculo vehiculo = VehiculoMother.fromRequest(request);

        VehiculoCreatedDomainEvent domainEvent = VehiculoCreatedDomainEventMother.fromCourse(vehiculo);

        creator.create(request);

        shouldHaveSaved(vehiculo);
        shouldHavePublished(domainEvent);
        
    }

    

    //Otro enfoque sin herencia
    /*@Test
    void guardar_vehiculo_valido_dos(){
        VehiculoRepository repository = mock(VehiculoRepository.class);
        VehiculoCreator creator = new VehiculoCreator(repository);

        CreateVehiculoRequest request = CreateVehiculoRequestMother.random();

        Vehiculo vehiculo = VehiculoMother.fromRequest(request);

        creator.create(request);

        verify(repository,atLeastOnce()).save(vehiculo);
    }*/
    
}
