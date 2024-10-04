package com.jplausi.PlataformaDeViajes.apps.command;

import com.jplausi.PlataformaDeViajes.shared.cli.ConsoleCommand;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.rabbit.RabbitMqDomainEventsConsumer;

public final class ConsumeRabbitMqDomainEventsCommand extends ConsoleCommand {

	private final RabbitMqDomainEventsConsumer consumer;

	public ConsumeRabbitMqDomainEventsCommand(RabbitMqDomainEventsConsumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void execute(String[] args) {
		consumer.consume();
	}
}
