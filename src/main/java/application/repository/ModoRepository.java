package application.repository;

import org.springframework.data.repository.CrudRepository;
import application.model.Modo;

public interface ModoRepository extends CrudRepository<Modo, Long> {
    public Modo findByDescricao(String descricao);
}
