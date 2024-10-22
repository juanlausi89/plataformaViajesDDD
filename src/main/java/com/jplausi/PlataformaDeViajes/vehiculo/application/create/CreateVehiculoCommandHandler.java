package com.jplausi.PlataformaDeViajes.vehiculo.application.create;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.command.CommandHandler;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoId;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoKm;
import com.jplausi.PlataformaDeViajes.vehiculo.domain.VehiculoPatente;

@Service
public final class CreateVehiculoCommandHandler implements CommandHandler<CreateVehiculoCommand> {
    private final VehiculoCreator creator;

    public CreateVehiculoCommandHandler(VehiculoCreator creator)  {
        this.creator = creator;
    }

    @Override
    public void handle(CreateVehiculoCommand command) {
        VehiculoId id = new VehiculoId(command.id());
        VehiculoPatente patente = new VehiculoPatente(command.patente());
        VehiculoKm km = new VehiculoKm(command.km());

        creator.create(id, patente, km);
    }
}
