package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKm;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatente;

final class VehiculoEnMemoriaRepositoryTest {

    @Test
    void guardar_un_vehiculo_valido(){
        
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();

        Vehiculo vehiculo = new Vehiculo(
            new VehiculoId("decf33ca-81a7-419f-a07a-74f214e928e5"), 
            new VehiculoPatente("some-patente"),
            new VehiculoKm( "some-km")
        );

        repository.save(vehiculo);
    }

    @Test
    void buscar_si_existe_vehiculo(){
        
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();

        Vehiculo vehiculo = new Vehiculo(
            new VehiculoId("decf33ca-81a7-419f-a07a-74f214e928e5"), 
            new VehiculoPatente("some-patente"),
            new VehiculoKm( "some-km")
        );

        repository.save(vehiculo);
        
        assertEquals(Optional.of(vehiculo), repository.search(vehiculo.getId().value()));
    }

    @Test
    void no_encontrar_un_vehiculo_que_no_existente() {
        VehiculoEnMemoriaRepository repository = new VehiculoEnMemoriaRepository();
        assertFalse(repository.search("non-existing-id").isPresent());
    }
    
}
