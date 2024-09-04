package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;

final class VehiculoEnMemoriaRepositoryTest {

    @Test
    void guardar_un_vehiculo_valido(){
        
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();

        repository.save(new Vehiculo("some-id", "some-patente", "some-km"));
    }

    @Test
    void buscar_si_existe_vehiculo(){
        
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();

        Vehiculo vehiculo = new Vehiculo("some-id", "some-patente", "some-km");

        repository.save(new Vehiculo("some-id", "some-patente", "some-km"));
        
        assertEquals(Optional.of(vehiculo), repository.search(vehiculo.getId()));
    }

    @Test
    void no_encontrar_un_vehiculo_que_no_existente() {
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();
        assertFalse(repository.search("non-existing-id").isPresent());
    }
    
}
