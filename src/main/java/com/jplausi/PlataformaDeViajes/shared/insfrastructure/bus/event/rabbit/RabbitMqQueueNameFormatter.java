package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.rabbit;

import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.DomainEventSubscriberInformation;

public class RabbitMqQueueNameFormatter {
    public static String format(DomainEventSubscriberInformation information) {
        return information.formatRabbitMqQueueName();
    }

    public static String formatRetry(DomainEventSubscriberInformation information) {
        return String.format("retry.%s", format(information));
    }

    public static String formatDeadLetter(DomainEventSubscriberInformation information) {
        return String.format("dead_letter.%s", format(information));
    }
}
