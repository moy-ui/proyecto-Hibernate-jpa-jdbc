package org.aguzman.apiservlet.webapp.headers.repositories;

import java.util.List;

public interface CrudRepository<T> {

    List<T> listar() throws Exception;
    T porId(long id) throws Exception;
    void guardar(T t) throws Exception;
    void eliminar(Long id)throws Exception;
}
