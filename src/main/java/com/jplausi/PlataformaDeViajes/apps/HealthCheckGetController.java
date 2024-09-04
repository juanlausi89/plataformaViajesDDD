package com.jplausi.PlataformaDeViajes.apps;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckGetController {
    @GetMapping("/health-check")
	public HashMap<String, String> index() {
		HashMap<String, String> status = new HashMap<>();
		status.put("application", "plataforma_viajes_backend");
		status.put("status", "ok");

		return status;
	}
	
}
