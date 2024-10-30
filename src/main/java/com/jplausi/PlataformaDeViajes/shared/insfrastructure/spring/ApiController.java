package com.jplausi.PlataformaDeViajes.shared.insfrastructure.spring;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

import com.jplausi.PlataformaDeViajes.shared.domain.DomainError;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.command.Command;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.command.CommandBus;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.command.CommandHandlerExecutionError;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.Query;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryBus;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryHandlerExecutionError;

public abstract class ApiController {
    private final QueryBus   queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
