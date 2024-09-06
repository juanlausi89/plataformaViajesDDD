package com.jplausi.PlataformaDeViajes.vehiculo;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;

import com.jplausi.PlataformaDeViajes.shared.insfrastructure.UnitTestCase;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

public abstract class VehiculoModuleUnitTestCase extends UnitTestCase {

    protected VehiculoRepository repository;
    
    @BeforeEach
    protected void setUp() {
        //super.setUp();
        repository = mock(VehiculoRepository.class);
    }

    public void shouldHaveSaved(Vehiculo vehiculo) {
        verify(repository, atLeastOnce()).save(vehiculo);
    }
}
