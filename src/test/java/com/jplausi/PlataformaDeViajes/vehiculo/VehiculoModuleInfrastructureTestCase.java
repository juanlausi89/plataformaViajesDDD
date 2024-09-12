package com.jplausi.PlataformaDeViajes.vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.jplausi.PlataformaDeViajes.PlataformaDeViajesApplication;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.InfrastructureTestCase;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;

@ContextConfiguration(classes = PlataformaDeViajesApplication.class)
@SpringBootTest
public abstract class VehiculoModuleInfrastructureTestCase extends InfrastructureTestCase {
     
    @Autowired
    protected VehiculoRepository repository;
}
