package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.rabbit;


import java.util.Collections;

import java.util.List;

import org.springframework.amqp.AmqpException;
import org.springframework.context.annotation.Primary;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.EventBus;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.mysql.MySqlEventBus;

@Primary
@Service
public class RabbitMqEventBus implements EventBus {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus     failoverPublisher;
    private final String            exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher, MySqlEventBus failoverPublisher) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
        this.exchangeName      = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            System.out.println(error);
            failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }
}
