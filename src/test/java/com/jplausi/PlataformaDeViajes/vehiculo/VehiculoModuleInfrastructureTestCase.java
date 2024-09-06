package com.jplausi.PlataformaDeViajes.vehiculo;

import org.springframework.beans.factory.annotation.Autowired;

import com.jplausi.PlataformaDeViajes.shared.insfrastructure.InfrastructureTestCase;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

public abstract class VehiculoModuleInfrastructureTestCase extends InfrastructureTestCase {
     
    @Autowired
    protected VehiculoRepository repository;
}
