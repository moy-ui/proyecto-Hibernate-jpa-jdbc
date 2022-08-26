package org.aguzman.apiservlet.webapp.headers.services;

import jakarta.inject.Inject;
import org.aguzman.apiservlet.webapp.headers.configs.ProductoServicePrincipal;
import org.aguzman.apiservlet.webapp.headers.configs.Service;
import org.aguzman.apiservlet.webapp.headers.interceptors.TransactionalJpa;
import org.aguzman.apiservlet.webapp.headers.models.entities.Categoria;
import org.aguzman.apiservlet.webapp.headers.models.entities.Producto;
import org.aguzman.apiservlet.webapp.headers.repositories.CrudRepository;
import org.aguzman.apiservlet.webapp.headers.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
@TransactionalJpa
public class ProductoServiceImpl implements ProductoService{

    @Inject
    @RepositoryJpa
    private CrudRepository<Producto> repositorio;
    @Inject
    @RepositoryJpa
    private CrudRepository<Categoria> repositorioCategoria;

    @Override
    public List<Producto> listar() {
        try {
            return repositorio.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositorio.porId(id));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositorio.guardar(producto);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositorio.eliminar(id);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositorioCategoria.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(long id) {
        try {
            return Optional.ofNullable(repositorioCategoria.porId(id));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
