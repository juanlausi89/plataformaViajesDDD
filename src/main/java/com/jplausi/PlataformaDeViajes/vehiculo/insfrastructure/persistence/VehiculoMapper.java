package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.jplausi.PlataformaDeViajes.vehiculo.domain.Vehiculo;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKm;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatente;

@Mapper
public interface VehiculoMapper {
    
    VehiculoMapper INSTANCE = Mappers.getMapper(VehiculoMapper.class);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToVehiculoId")
    @Mapping(source = "patente", target = "patente", qualifiedByName = "stringToVehiculoPatente")
    @Mapping(source = "km", target = "km", qualifiedByName = "stringToVehiculoKm")
    Vehiculo vehiculoEntityToVehiculo(VehiculoEntity vehiculoEntity);

    @Mapping(source = "id", target = "id", qualifiedByName = "vehiculoIdToString")
    @Mapping(source = "patente", target = "patente", qualifiedByName = "vehiculoPatenteToString")
    @Mapping(source = "km", target = "km", qualifiedByName = "vehiculoKmToString")
    VehiculoEntity vehiculoToVehiculoEntity(Vehiculo vehiculo);

    // Mapeos personalizados
    @Named("stringToVehiculoId")
    default VehiculoId stringToVehiculoId(String id) {
        return new VehiculoId(id != null ? id.toString() : null);
    }

    @Named("vehiculoIdToString")
    default String vehiculoIdToString(VehiculoId id) {
        return id != null ? String.valueOf(id.value()) : null;
    }

    @Named("stringToVehiculoPatente")
    default VehiculoPatente stringToVehiculoPatente(String patente) {
        return new VehiculoPatente(patente);
    }

    @Named("vehiculoPatenteToString")
    default String vehiculoPatenteToString(VehiculoPatente patente) {
        return patente != null ? patente.value() : null;
    }

    @Named("stringToVehiculoKm")
    default VehiculoKm stringToVehiculoKm(String km) {
        return new VehiculoKm(km);
    }

    @Named("vehiculoKmToString")
    default String vehiculoKmToString(VehiculoKm km) {
        return km != null ? km.value() : null;
    }
}
