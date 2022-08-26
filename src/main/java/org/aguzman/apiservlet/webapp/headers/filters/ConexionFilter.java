package org.aguzman.apiservlet.webapp.headers.filters;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.apiservlet.webapp.headers.configs.MysqlConn;
import org.aguzman.apiservlet.webapp.headers.services.ServiceJdbcException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {

//    @Inject
//    @MysqlConn
//    private Connection conn;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*try {
            Connection connRequest =this.conn;
            if(connRequest.getAutoCommit()){
                connRequest.setAutoCommit(false);
            }

         */
            try {
                //servletRequest.setAttribute("conn", connRequest);
                filterChain.doFilter(servletRequest, servletResponse);
                //connRequest.commit();
            }catch (ServiceJdbcException e){
                //connRequest.rollback();
                ((HttpServletResponse)servletResponse).sendError(500, e.getMessage());
                e.printStackTrace();
            }
       /* } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */
    }
}
