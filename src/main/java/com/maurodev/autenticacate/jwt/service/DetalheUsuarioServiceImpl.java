package com.maurodev.autenticacate.jwt.service;

import com.maurodev.autenticacate.jwt.data.DetalheUsuarioData;
import com.maurodev.autenticacate.jwt.model.UsuarioModel;
import com.maurodev.autenticacate.jwt.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component // para saber que ele e um componente spring
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario = repository.findByLogin(username);

        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuario [" + username + "] nao encontrado!");
        }
        return new DetalheUsuarioData(usuario);
    }
}
