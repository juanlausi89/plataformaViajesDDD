package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure.persistence;

import org.springframework.data.repository.CrudRepository;

public interface JpaVehiculoRepository extends CrudRepository<VehiculoEntity,String> {
    
}
