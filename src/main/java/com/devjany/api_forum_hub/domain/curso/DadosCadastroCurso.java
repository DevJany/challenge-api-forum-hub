package com.devjany.api_forum_hub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(

        Long id,

        @NotBlank
        String nome,

        @NotNull
        CategoriaCurso categoria) {
}
