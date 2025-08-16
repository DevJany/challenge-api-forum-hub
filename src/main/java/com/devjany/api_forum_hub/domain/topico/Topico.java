package com.devjany.api_forum_hub.domain.topico;

import com.devjany.api_forum_hub.domain.curso.Curso;
import com.devjany.api_forum_hub.domain.resposta.Resposta;
import com.devjany.api_forum_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Resposta> respostas = new ArrayList<>();


    public Topico(DadosCadastroTopico dados, Usuario autor, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDateTime.now();
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.autor = autor;
        this.curso = curso;

    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {

        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }

        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

        if (dados.status() != null){
            this.status = dados.status();
        }
    }
}
