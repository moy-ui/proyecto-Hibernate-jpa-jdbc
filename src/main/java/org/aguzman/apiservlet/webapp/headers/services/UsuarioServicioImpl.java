package org.aguzman.apiservlet.webapp.headers.services;

import jakarta.inject.Inject;
import org.aguzman.apiservlet.webapp.headers.configs.Service;
import org.aguzman.apiservlet.webapp.headers.interceptors.TransactionalJpa;
import org.aguzman.apiservlet.webapp.headers.models.entities.Usuario;
import org.aguzman.apiservlet.webapp.headers.repositories.RepositoryJpa;
import org.aguzman.apiservlet.webapp.headers.repositories.UsuarioRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
@TransactionalJpa
public class UsuarioServicioImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServicioImpl( @RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username))
                    .filter(u -> u.getPassword().equals(password));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
