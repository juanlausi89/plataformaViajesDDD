package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.mysql;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.Utils;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.EventBus;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.DomainEventsInformation;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.spring.SpringApplicationEventBus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class MySqlDomainEventsConsumer {
    @PersistenceContext
    private EntityManager entityManager;

    private final DomainEventsInformation domainEventsInformation;
    //private final EventBus bus;
    private final Integer CHUNKS = 200;
    private final SpringApplicationEventBus bus;
    private Boolean shouldStop = false;

    public MySqlDomainEventsConsumer(
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus,
        EntityManager entityManager // Agrega EntityManager aquí
    ) {
        this.domainEventsInformation = domainEventsInformation;
        this.bus = bus;
        this.entityManager = entityManager; // Asignar EntityManager
    }

    @Transactional
    public void consume() {
        while (!shouldStop) {
            List<Object[]> events = entityManager.createNativeQuery(
                "SELECT * FROM domain_events ORDER BY occurred_on ASC LIMIT :chunk"
            )
            .setParameter("chunk", CHUNKS)
            .getResultList();

            try {
                for (Object[] event : events) {
                    executeSubscribers(
                        (String) event[0],
                        (String) event[1],
                        (String) event[2],
                        (String) event[3],
                        (Timestamp) event[4]
                    );
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }

            entityManager.clear();
        }
    }

    public void stop() {
        shouldStop = true;
    }

    private void executeSubscribers(
        String id, String aggregateId, String eventName, String body, Timestamp occurredOn
    ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends DomainEvent> domainEventClass = domainEventsInformation.forName(eventName);
        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();

        Method fromPrimitivesMethod = domainEventClass.getMethod(
            "fromPrimitives",
            String.class,
            HashMap.class,
            String.class,
            String.class
        );

        Object domainEvent = fromPrimitivesMethod.invoke(
            nullInstance,
            aggregateId,
            Utils.jsonDecode(body),
            id,
            Utils.dateToString(occurredOn)
        );

        bus.publish(Collections.singletonList((DomainEvent) domainEvent));
    }
}
