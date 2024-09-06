package com.jplausi.PlataformaDeViajes.vehiculo.domain;

import java.util.Optional;

public interface VehiculoRepository {

    public void save(Vehiculo vehiculo);

    Optional<Vehiculo> search(VehiculoId id);
    
    
}
