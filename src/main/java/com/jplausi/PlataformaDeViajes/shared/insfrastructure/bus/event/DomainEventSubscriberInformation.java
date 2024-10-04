package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event;

import java.util.List;

import com.jplausi.PlataformaDeViajes.shared.domain.Utils;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;

public class DomainEventSubscriberInformation {
     private final Class<?>                           subscriberClass;
    private final List<Class<? extends DomainEvent>> subscribedEvents;

    public DomainEventSubscriberInformation(
        Class<?> subscriberClass,
        List<Class<? extends DomainEvent>> subscribedEvents
    ) {
        this.subscriberClass  = subscriberClass;
        this.subscribedEvents = subscribedEvents;
    }

    public Class<?> subscriberClass() {
        return subscriberClass;
    }

    public String contextName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[2];
    }

    public String moduleName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[3];
    }

    public String className() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[nameParts.length - 1];
    }

    public List<Class<? extends DomainEvent>> subscribedEvents() {
        return subscribedEvents;
    }

    public String formatRabbitMqQueueName() {
        return String.format("jplausi.%s.%s.%s", contextName(), moduleName(), Utils.toSnake(className()));
    }
}
