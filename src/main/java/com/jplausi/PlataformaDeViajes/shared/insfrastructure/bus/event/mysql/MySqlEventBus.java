package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.context.annotation.Primary;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.Utils;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.EventBus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class MySqlEventBus implements EventBus {
    @PersistenceContext
    private EntityManager entityManager;

    public MySqlEventBus(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        String id = domainEvent.eventId();
        String aggregateId = domainEvent.aggregateId();
        String name = domainEvent.eventName();
        HashMap<String, Serializable> body = domainEvent.toPrimitives();
        String occurredOn = domainEvent.occurredOn();

        entityManager.createNativeQuery(
            "INSERT INTO domain_events (id, aggregate_id, name, body, occurred_on) " +
            "VALUES (:id, :aggregateId, :name, :body, :occurredOn)"
        )
        .setParameter("id", id)
        .setParameter("aggregateId", aggregateId)
        .setParameter("name", name)
        .setParameter("body", Utils.jsonEncode(body))
        .setParameter("occurredOn", occurredOn)
        .executeUpdate();
    }
}
