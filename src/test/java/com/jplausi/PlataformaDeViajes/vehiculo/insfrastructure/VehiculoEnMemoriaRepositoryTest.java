package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.jplausi.PlataformaDeViajes.vehiculo.VehiculoModuleInfrastructureTestCase;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoIdMother;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoMother;


final class VehiculoEnMemoriaRepositoryTest extends VehiculoModuleInfrastructureTestCase {

    @Test
    void guardar_un_vehiculo_valido(){
        
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();

        Vehiculo vehiculo = VehiculoMother.random();

        repository.save(vehiculo);
    }

    @Test
    void buscar_si_existe_vehiculo(){
        
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();

        Vehiculo vehiculo = VehiculoMother.random();

        repository.save(vehiculo);
        
        assertEquals(Optional.of(vehiculo), repository.search(vehiculo.getId()));
    }

    @Test
    void no_encontrar_un_vehiculo_que_no_existente() {
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();
        assertFalse(repository.search(VehiculoIdMother.random()).isPresent());
    }
    
}
