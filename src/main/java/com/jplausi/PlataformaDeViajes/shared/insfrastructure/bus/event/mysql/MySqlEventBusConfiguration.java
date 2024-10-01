package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.mysql;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.DomainEventsInformation;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.spring.SpringApplicationEventBus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class MySqlEventBusConfiguration {
    @PersistenceContext
    private EntityManager entityManager;

    private final DomainEventsInformation domainEventsInformation;
    private final SpringApplicationEventBus bus;

    public MySqlEventBusConfiguration(
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus
    ) {
        this.domainEventsInformation = domainEventsInformation;
        this.bus = bus;
    }

    @Bean
    public MySqlEventBus mysqlEventBus() {
        return new MySqlEventBus(entityManager);
    }

    @Bean
    public MySqlDomainEventsConsumer mySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(domainEventsInformation, bus, entityManager);
    }
}
