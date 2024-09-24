package com.jplausi.PlataformaDeViajes.shared.insfrastructure;

import java.util.UUID;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.UuidGenerator;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
