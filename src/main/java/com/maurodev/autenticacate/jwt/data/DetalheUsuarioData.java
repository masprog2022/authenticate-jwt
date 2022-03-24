package com.maurodev.autenticacate.jwt.data;


import com.maurodev.autenticacate.jwt.model.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheUsuarioData implements UserDetails {

    private final Optional<UsuarioModel> usuario;

    public DetalheUsuarioData(Optional<UsuarioModel> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new UsuarioModel()).getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new UsuarioModel()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() { // Verifica se a conta n esta expirada
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // Verifica se a conta n esta bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // Verifica se as credencias n esta expirada
        return true;
    }

    @Override
    public boolean isEnabled() { // se a conta esta activa
        return true;
    }
}
