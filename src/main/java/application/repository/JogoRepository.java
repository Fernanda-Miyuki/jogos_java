package application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import application.model.Jogo;

public interface JogoRepository extends CrudRepository<Jogo, Long> {
    public List<Jogo> findByTitulo(String titulo);
}
