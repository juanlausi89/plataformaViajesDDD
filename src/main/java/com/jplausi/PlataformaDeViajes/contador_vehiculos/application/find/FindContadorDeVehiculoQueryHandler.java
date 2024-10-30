package com.jplausi.PlataformaDeViajes.contador_vehiculos.application.find;

import com.jplausi.PlataformaDeViajes.contador_vehiculos.domain.CantidadVehiculosId;
import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryHandler;

@Service
public class FindContadorDeVehiculoQueryHandler implements QueryHandler<FindContadorDeVehiculoQuery, ContadorDeVehiculoResponse> {
    
    private final ContadorVehiculoFinder finder;

    public FindContadorDeVehiculoQueryHandler(ContadorVehiculoFinder finder) {
        this.finder = finder;
    }

    @Override
    public ContadorDeVehiculoResponse handle(FindContadorDeVehiculoQuery query) {
        return finder.find(new CantidadVehiculosId(query.id()));
    }
}
