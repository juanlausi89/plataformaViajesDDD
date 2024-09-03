package com.jplausi.PlataformaDeViajes.apps.vehiculo;

import org.junit.jupiter.api.Test;

import com.jplausi.PlataformaDeViajes.ApplicationTestCase;

public class VehiculoPutControllerTest extends ApplicationTestCase {
    
    @Test
    void crear_vehiculo_valido() throws Exception{
        assertRequestWithBody("PUT", "/vehiculo/1aab45ba-3c7a-4344-8936-78466eca77fa", """
    {
        "patente": "AB614YD",
        "km": "10000"
    }
    """, 201);
    }
}
