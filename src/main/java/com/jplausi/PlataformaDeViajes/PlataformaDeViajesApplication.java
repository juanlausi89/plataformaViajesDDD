package com.jplausi.PlataformaDeViajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;

@SpringBootApplication
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"com.jplausi.PlataformaDeViajes"}
)
public class PlataformaDeViajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaDeViajesApplication.class, args);
	}

}
