package com.jplausi.PlataformaDeViajes.shared.domain.vehiculo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import com.jplausi.PlataformaDeViajes.shared.domain.bus.event.DomainEvent;

public class VehiculoCreatedDomainEvent extends DomainEvent<VehiculoCreatedDomainEvent> {
    private final String patente;
    private final String km;

    public VehiculoCreatedDomainEvent() {
        super(null);

        this.patente     = null;
        this.km = null;
    }

    public VehiculoCreatedDomainEvent(String aggregateId, String patente, String km) {
        super(aggregateId);

        this.patente = patente;
        this.km = km;
    }

    public VehiculoCreatedDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String patente,
        String km
    ) {
        super(aggregateId, eventId, occurredOn);

        this.patente = patente;
        this.km = km;
    }

    @Override
    public String eventName() {
        return "vehiculo.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("patente", patente);
            put("km", km);
        }};
    }

    @Override
    public VehiculoCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new VehiculoCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("patente"),
            (String) body.get("km")
        );
    }

    public String patente() {
        return patente;
    }

    public String km() {
        return km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VehiculoCreatedDomainEvent that = (VehiculoCreatedDomainEvent) o;
        return patente.equals(that.patente) &&
               km.equals(that.km);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente, km);
    }
}
