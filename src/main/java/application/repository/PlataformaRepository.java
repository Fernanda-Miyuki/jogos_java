package application.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import application.model.Plataforma;

public interface PlataformaRepository extends CrudRepository<Plataforma, Long> {
    Optional<Plataforma> findByDescricao(String descricao);
}
