package org.aguzman.apiservlet.webapp.headers.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.aguzman.apiservlet.webapp.headers.configs.Repository;
import org.aguzman.apiservlet.webapp.headers.models.entities.Producto;

import java.util.List;

@Repository
@RepositoryJpa
public class ProductoRepositoryJpaImpl implements  CrudRepository<Producto> {

    @Inject
    private EntityManager em;
    @Override
    public List<Producto> listar() throws Exception {
        return em.createQuery("select p from Producto p left join fetch p.categoria", Producto.class).getResultList();
    }

    @Override
    public Producto porId(long id) throws Exception {
        return em.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) throws Exception {
        if(producto.getId() != null && producto.getId() > 0){
            em.merge(producto);
        }else {
            em.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        em.remove(porId(id));
    }
}
