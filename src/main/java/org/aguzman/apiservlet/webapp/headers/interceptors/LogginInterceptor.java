package org.aguzman.apiservlet.webapp.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging
@Interceptor
public class LogginInterceptor {

    @Inject
    private Logger log;

    @AroundInvoke
    public Object loggin(InvocationContext invocation) throws Exception {

        log.info("*******  entrando antes de invocar el metodo *******" +
                invocation.getMethod().getDeclaringClass());
        Object resultado = invocation.proceed();

        log.info(" ******* saliendo de la invocación del metodo" +
                invocation.getMethod().getName());

        return resultado;
    }
}
