package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import com.jplausi.PlataformaDeViajes.shared.domain.bus.command.Command;

//usar
public class CreateVehiculoCommand implements Command {
    private final String id;
    private final String patente;
    private final String km;

    public CreateVehiculoCommand(String id, String patente, String km) {
        this.id       = id;
        this.patente     = patente;
        this.km = km;
    }

    public String id() {
        return id;
    }

    public String patente() {
        return patente;
    }

    public String km() {
        return km;
    }
}
