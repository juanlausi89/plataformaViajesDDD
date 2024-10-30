package com.jplausi.PlataformaDeViajes.shared.insfrastructure.bus.query;

import com.jplausi.PlataformaDeViajes.shared.domain.Service;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.Query;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryBus;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryHandler;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.QueryHandlerExecutionError;
import com.jplausi.PlataformaDeViajes.shared.domain.bus.query.Response;

import org.springframework.context.ApplicationContext;

@Service
public final class InMemoryQueryBus implements QueryBus {
    private final QueryHandlersInformation information;
    private final ApplicationContext       context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public Response ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

            QueryHandler handler = context.getBean(queryHandlerClass);

            return handler.handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }
}
