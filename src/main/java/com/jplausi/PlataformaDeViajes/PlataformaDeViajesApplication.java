package com.jplausi.PlataformaDeViajes;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.jplausi.PlataformaDeViajes.apps.command.ConsumeMySqlDomainEventsCommand;
import com.jplausi.PlataformaDeViajes.apps.command.ConsumeRabbitMqDomainEventsCommand;
import com.jplausi.PlataformaDeViajes.shared.cli.ConsoleCommand;
import com.jplausi.PlataformaDeViajes.shared.domain.Service;

@SpringBootApplication
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"com.jplausi.PlataformaDeViajes"}
)
public class PlataformaDeViajesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PlataformaDeViajesApplication.class, args);
		
		SpringApplication app = new SpringApplication(PlataformaDeViajesApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        // Definir valores fijos para applicationName y commandName
        String applicationName = "PlataformaDeViajesApplication"; // o el nombre correspondiente
        String commandName = "domain-events:rabbitmq:consume"; // o el comando que desees ejecutar

        // Si es un comando de servidor, puedes manejarlo aquí
        boolean isServerCommand = commandName.equals("server");
        
        if (!isServerCommand) {
            ConsoleCommand command = (ConsoleCommand) context.getBean(commands().get(applicationName).get(commandName));

            // Ejecutar el comando (puedes pasar parámetros si lo deseas)
            command.execute(new String[]{}); // Pasa argumentos si los necesitas
        }
	}

	private static HashMap<String, HashMap<String, Class<?>>> commands() {
		HashMap<String, HashMap<String, Class<?>>> commands = new HashMap<>();

		commands.put("PlataformaDeViajesApplication", eventos());

		return commands;
	}

	public static HashMap<String, Class<?>> eventos() {
		
		return new HashMap<String, Class<?>>() {
			{
				put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
				put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
			}
		};
	}

	

	

}
