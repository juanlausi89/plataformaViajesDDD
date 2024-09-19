package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jplausi.PlataformaDeViajes.vehiculo.VehiculoModuleInfrastructureTestCase;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoIdMother;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoMother;
import com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure.persistence.JpaVehiculoRepository;

import jakarta.transaction.Transactional;


@Transactional
public class VehiculoEnMysqlRepository extends VehiculoModuleInfrastructureTestCase {

    @Autowired
    private JpaVehiculoRepository jpaVehiculoRepository;


   @Test
    void guardar_un_vehiculo_valido(){

        MysqlVehiculoRepository repository = new MysqlVehiculoRepository(jpaVehiculoRepository);

        Vehiculo vehiculo = VehiculoMother.random();

        repository.save(vehiculo);
    }

    @Test
    void buscar_si_existe_vehiculo(){
        
        MysqlVehiculoRepository repository = new MysqlVehiculoRepository(jpaVehiculoRepository);

        Vehiculo vehiculo = VehiculoMother.random();

        repository.save(vehiculo);
        
        assertEquals(Optional.of(vehiculo), repository.search(vehiculo.getId()));
    }

    @Test
    void no_encontrar_un_vehiculo_que_no_existente() {
        MysqlVehiculoRepository repository = new MysqlVehiculoRepository(jpaVehiculoRepository);
        assertFalse(repository.search(VehiculoIdMother.random()).isPresent());
    } 
}
