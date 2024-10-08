package com.jplausi.PlataformaDeViajes.shared.insfrastructure.config;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class Parameter {
    private final Dotenv dotenv;

    public Parameter(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public String get(String key) throws ParameterNotExist {
        String value = dotenv.get(key);

        if (null == value) {
            throw new ParameterNotExist(key);
        }

        return value;
    }

    public Integer getInt(String key) throws ParameterNotExist {
        String value = get(key);

        return Integer.parseInt(value);
    }
}
