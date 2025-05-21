package application.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jogos")
@Getter
@Setter
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titulo;

    // Um jogo tem apenas um modo
    @ManyToOne
    @JoinColumn(name = "id_modo", nullable = false)
    private Modo modo;

    // Um jogo pode ter vários gêneros
    @ManyToMany
    @JoinTable(name = "jogo_tem_generos",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private Set<Genero> generos = new HashSet<>();

    // Um jogo pode estar disponível em várias plataformas
    @ManyToMany
    @JoinTable(name = "jogo_tem_plataformas",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_plataforma"))
    private Set<Plataforma> plataformas = new HashSet<>();
}
