package com.devjany.api_forum_hub.domain.topico;

import com.devjany.api_forum_hub.domain.resposta.DadosListagemResposta;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoTopico(String titulo,
                                      String mensagem,
                                      LocalDateTime data,
                                      StatusTopico status,
                                      String autor,
                                      String curso,
                                      List<DadosListagemResposta> respostas) {

    public DadosDetalhamentoTopico(Topico topico) {

        this(topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor().getNome(), topico.getCurso().getNome(), topico.getRespostas().stream().map(DadosListagemResposta::new).toList());
    }
}
