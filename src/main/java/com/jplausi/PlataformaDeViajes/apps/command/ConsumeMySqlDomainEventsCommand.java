package com.jplausi.PlataformaDeViajes.apps.command;

import com.jplausi.PlataformaDeViajes.shared.cli.ConsoleCommand;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.event.mysql.MySqlDomainEventsConsumer;

public final class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {

	private final MySqlDomainEventsConsumer consumer;

	public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void execute(String[] args) {
		consumer.consume();
	}
}
