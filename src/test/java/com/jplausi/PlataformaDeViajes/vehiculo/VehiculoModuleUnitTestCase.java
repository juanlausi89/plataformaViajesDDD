package com.jplausi.PlataformaDeViajes.vehiculo;

import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;


import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.EventBus;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.UnitTestCase;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

public abstract class VehiculoModuleUnitTestCase extends UnitTestCase {

    protected VehiculoRepository repository;
    protected EventBus eventBus;
    
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(VehiculoRepository.class);
        //eventBus = mock(EventBus.class);
    }

    public void shouldHaveSaved(Vehiculo vehiculo) {
        verify(repository, atLeastOnce()).save(vehiculo);
    }

    public void shouldHavePublished(DomainEvent<?> domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }
}
