package br.com.encurtador.encurtador.repository;

import br.com.encurtador.encurtador.model.UrlEncurtada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlEncurtadaRepository extends JpaRepository<UrlEncurtada,Long> {

    UrlEncurtada findByEncurtada(String encurtada);
}
