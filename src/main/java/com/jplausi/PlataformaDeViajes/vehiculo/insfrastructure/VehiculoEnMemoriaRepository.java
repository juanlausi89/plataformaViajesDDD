package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure;

import java.util.HashMap;
import java.util.Optional;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;


@Service
public class VehiculoEnMemoriaRepository implements VehiculoRepository {
    
    private HashMap<String,Vehiculo> vehiculos = new HashMap<>();

    @Override
    public void save(Vehiculo vehiculo) {
        vehiculos.put(vehiculo.getId().value(), vehiculo);
    }

    @Override
    public Optional<Vehiculo> search(VehiculoId id) {
        return Optional.ofNullable(vehiculos.get(id.value()));
    }
    
}
