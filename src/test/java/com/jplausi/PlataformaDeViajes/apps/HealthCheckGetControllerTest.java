package com.jplausi.PlataformaDeViajes.apps;

import org.junit.jupiter.api.Test;

import com.jplausi.PlataformaDeViajes.ApplicationTestCase;

public class HealthCheckGetControllerTest extends ApplicationTestCase {

    @Test
    void chequeo_de_salud_esta_funcionando()throws Exception{
        assertResponse("/health-check",200,"{'status':'ok'}");
    }
    
}
