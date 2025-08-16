package com.devjany.api_forum_hub.domain.perfil;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNomeIgnoreCase(String nome);

}
