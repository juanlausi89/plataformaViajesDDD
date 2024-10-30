package com.jplausi.PlataformaDeViajes.apps.contadorDeVehiculos;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jplausi.PlataformaDeViajes.contador_vehiculos.application.find.ContadorDeVehiculoResponse;
import com.jplausi.PlataformaDeViajes.contador_vehiculos.application.find.FindContadorDeVehiculoQuery;
import com.jplausi.PlataformaDeViajes.shared.domain.DomainError;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.command.CommandBus;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryBus;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryHandlerExecutionError;
import com.jplausi.PlataformaDeViajes.shared.insfrastructure.spring.ApiController;

@RestController
public class ContadorDeVehiculosGetController extends ApiController {

    public ContadorDeVehiculosGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/vehiculos-cantidad/{id}")
	public HashMap<String, Integer> index(@PathVariable String id) throws QueryHandlerExecutionError {
		ContadorDeVehiculoResponse response = ask(new FindContadorDeVehiculoQuery(id));

		return new HashMap<String, Integer>() {
			{
				put("total", response.total());
			}
		};
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
    
}
