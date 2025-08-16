package com.devjany.api_forum_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(

        Long id,

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        DadosCadastroTopico curso) {
}
