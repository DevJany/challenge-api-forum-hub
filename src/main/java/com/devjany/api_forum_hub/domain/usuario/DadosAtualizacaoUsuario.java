package com.devjany.api_forum_hub.domain.usuario;

import jakarta.validation.constraints.Email;

import java.util.Set;

public record DadosAtualizacaoUsuario(String nome,

                                      @Email
                                      String email,
                                      String senha,
                                      Set<Long> perfisIds) {
}
