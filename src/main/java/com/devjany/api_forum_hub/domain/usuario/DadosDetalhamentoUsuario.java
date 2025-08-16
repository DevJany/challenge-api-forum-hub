package com.devjany.api_forum_hub.domain.usuario;

import com.devjany.api_forum_hub.domain.perfil.Perfil;

import java.util.Set;
import java.util.stream.Collectors;

public record DadosDetalhamentoUsuario(Long id,
                                       String nome,
                                       String email,
                                       Set<String> perfis) {

    public DadosDetalhamentoUsuario(Usuario usuario) {

        this(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                usuario.getPerfis().stream()
                        .map(Perfil::getNome)
                        .collect(Collectors.toSet()));
    }
}

