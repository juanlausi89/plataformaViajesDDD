package com.jplausi.PlataformaDeViajes.contador_vehiculos.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculos;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosId;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosTotal;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;


@Mapper
public interface CantidadVehiculosMapper {

    CantidadVehiculosMapper INSTANCE = Mappers.getMapper(CantidadVehiculosMapper.class);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToCantidadVehiculoId")
    @Mapping(source = "total", target = "total", qualifiedByName = "integerToCantidadVehiculoTotal")
    @Mapping(source = "existenVehiculos", target = "existenVehiculos", qualifiedByName = "stringToCantidadVehiculosIdList")
    CantidadVehiculos cantidadVehiculoEntityToCantidadVehiculo(CantidadVehiculoEntity cantidadVehiculoEntity);

    @Mapping(source = "id", target = "id", qualifiedByName = "cantidadVehiculoIdToString")
    @Mapping(source = "total", target = "total", qualifiedByName = "cantidadVehiculoTotalToInteger")
    @Mapping(source = "existenVehiculos", target = "existenVehiculos", qualifiedByName = "cantidadVehiculosIdListToString")
    CantidadVehiculoEntity cantidadVehiculoToCantidadVehiculoEntity(CantidadVehiculos vehiculo);

    // Métodos de mapeo personalizados
    @Named("stringToCantidadVehiculoId")
    default CantidadVehiculosId stringToCantidadVehiculoId(String id) {
        return new CantidadVehiculosId(id);
    }

    @Named("cantidadVehiculoIdToString")
    default String cantidadVehiculoIdToString(CantidadVehiculosId id) {
        return id != null ? id.value() : null;
    }

    @Named("integerToCantidadVehiculoTotal")
    default CantidadVehiculosTotal integerToCantidadVehiculoTotal(Integer total) {
        return new CantidadVehiculosTotal(total);
    }

    @Named("cantidadVehiculoTotalToInteger")
    default Integer cantidadVehiculoTotalToInteger(CantidadVehiculosTotal total) {
        return total != null ? total.value() : null;
    }

    @Named("stringToCantidadVehiculosIdList")
    default List<VehiculoId> stringToCantidadVehiculosIdList(String existVehicles) {
        if (existVehicles == null || existVehicles.isEmpty()) {
            return List.of(); // Devuelve una lista vacía
        }
        return List.of(existVehicles.split(",")).stream()
                   .map(VehiculoId::new)
                   .toList();
    }

    @Named("cantidadVehiculosIdListToString")
    default String cantidadVehiculosIdListToString(List<VehiculoId> ids) {
        if (ids == null || ids.isEmpty()) {
            return ""; // Devuelve una cadena vacía
        }
        return ids.stream()
                  .map(VehiculoId::value)
                  .collect(Collectors.joining(","));
    }
}

