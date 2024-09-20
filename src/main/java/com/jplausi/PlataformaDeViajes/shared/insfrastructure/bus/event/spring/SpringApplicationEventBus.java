package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.spring;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.EventBus;

@Primary
@Service
public class SpringApplicationEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent<?>> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent<?> event) {
        this.publisher.publishEvent(event);
    }
}
