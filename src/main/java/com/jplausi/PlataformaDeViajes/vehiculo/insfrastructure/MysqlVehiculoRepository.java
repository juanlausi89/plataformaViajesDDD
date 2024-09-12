package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure;

import java.util.Optional;


import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoRepository;
import com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure.persistence.JpaVehiculoRepository;
import com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure.persistence.VehiculoEntity;
import com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure.persistence.VehiculoMapper;

import jakarta.transaction.Transactional;


@Service
public class MysqlVehiculoRepository implements VehiculoRepository {

    private JpaVehiculoRepository repository;

    private final VehiculoMapper mapper = VehiculoMapper.INSTANCE;

    public MysqlVehiculoRepository(JpaVehiculoRepository repository){
        this.repository = repository;
    }

    @Transactional
    @Override
    public void save(Vehiculo vehiculo) {
        System.out.println(vehiculo.toString());
        VehiculoEntity vehiculoEntity = mapper.vehiculoToVehiculoEntity(vehiculo);
        repository.save(vehiculoEntity);
    }

    @Override
    public Optional<Vehiculo> search(VehiculoId id) {
        Optional<VehiculoEntity> vehiculoEntity = repository.findById(id.value());
        return vehiculoEntity.map(entity -> mapper.vehiculoEntityToVehiculo(entity));
    }

}
