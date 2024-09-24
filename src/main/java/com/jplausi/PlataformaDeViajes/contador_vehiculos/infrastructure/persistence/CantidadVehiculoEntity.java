package com.jplausi.PlataformaDeViajes.contador_vehiculos.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contador_de_vehiculos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CantidadVehiculoEntity {
    @Id
    private String id;
    
    private Integer total;
    private String existenVehiculos;
}
