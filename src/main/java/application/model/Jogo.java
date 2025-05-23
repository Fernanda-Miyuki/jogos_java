package application.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//entidade mais complexa com relacionamentos//

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

    @ManyToOne //2       n-1 (many to one)//
    @JoinColumn(name = "id_modo", nullable = false) //3//
    private Modo modo; //1//

    @ManyToMany
    @JoinTable(name = "jogos_tem_generos",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private Set<Genero> generos = new HashSet<Genero>();

    @ManyToMany
    @JoinTable(name = "jogos_tem_plataformas",
        joinColumns = @JoinColumn(name = "id_jogo"),
        inverseJoinColumns = @JoinColumn(name = "id_plataforma"))
    private Set<Plataforma> plataformas = new HashSet<Plataforma>();
}
