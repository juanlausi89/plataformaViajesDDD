package com.jplausi.PlataformaDeViajes.contador_vehiculos.infrastructure;

import java.util.Optional;

import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculos;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosId;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosRepository;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.infrastructure.persistence.CantidadVehiculoEntity;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.infrastructure.persistence.CantidadVehiculosMapper;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.infrastructure.persistence.JpaCantidadVehiculoRepository;
import com.jplausi.PlataformaDeViajes.shared.domain.Service;


import jakarta.transaction.Transactional;

@Service
public class MysqlCantidadVehiculoRepository implements CantidadVehiculosRepository {

    private JpaCantidadVehiculoRepository repository;

    private final CantidadVehiculosMapper mapper = CantidadVehiculosMapper.INSTANCE;

    public MysqlCantidadVehiculoRepository(JpaCantidadVehiculoRepository repository){
        this.repository = repository;
    }

    @Transactional
    @Override
    public void save(CantidadVehiculos cantidadVehiculo) {
        CantidadVehiculoEntity cantidadVehiculoEntity = mapper.cantidadVehiculoToCantidadVehiculoEntity(cantidadVehiculo);
        repository.save(cantidadVehiculoEntity);
    }

    @Override
    public Optional<CantidadVehiculos> search(CantidadVehiculosId id) {
        Optional<CantidadVehiculoEntity> cantidadVehiculoEntity = repository.findById(id.value());
        return cantidadVehiculoEntity.map(entity -> mapper.cantidadVehiculoEntityToCantidadVehiculo(entity));
    }
    
}
