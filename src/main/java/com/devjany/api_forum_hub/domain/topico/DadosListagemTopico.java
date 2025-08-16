package com.devjany.api_forum_hub.domain.topico;

import com.devjany.api_forum_hub.domain.curso.DadosListagemCurso;
import com.devjany.api_forum_hub.domain.usuario.DadosUsuario;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id,
                                  String titulo,
                                  String mensagem,
                                  LocalDateTime data,
                                  StatusTopico status,
                                  DadosUsuario autor,
                                  DadosListagemCurso curso) {


    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), new DadosUsuario(topico.getAutor()), new DadosListagemCurso(topico.getCurso()));
    }
}
