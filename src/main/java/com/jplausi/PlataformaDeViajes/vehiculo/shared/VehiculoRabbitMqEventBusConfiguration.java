package com.jplausi.PlataformaDeViajes.vehiculo.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.mysql.MySqlEventBus;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.rabbit.RabbitMqEventBus;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.rabbit.RabbitMqPublisher;

@Configuration
public class VehiculoRabbitMqEventBusConfiguration {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus     failoverPublisher;

    public VehiculoRabbitMqEventBusConfiguration(
        RabbitMqPublisher publisher,
        MySqlEventBus failoverPublisher
    ) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
    }

    @Bean
    public RabbitMqEventBus moocRabbitMqEventBus() {
        return new RabbitMqEventBus(publisher, failoverPublisher);
    }
}
