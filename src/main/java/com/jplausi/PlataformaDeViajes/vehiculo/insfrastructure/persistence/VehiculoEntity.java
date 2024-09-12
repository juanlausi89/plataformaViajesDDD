package com.jplausi.PlataformaDeViajes.vehiculo.insfrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vehiculos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VehiculoEntity {
    
    @Id
    private String id;
    
    private String patente;
    private String km;
}
