package fr.syfo.cinema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titre;

    @NotBlank
    private String dateDeSortie;

    @NotBlank
    private int duree;

    @NotBlank
    @Size(min = 50, max = 500)
    private String resume;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "film_acteur",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_acteur")
    )
    private List<Acteur> acteurs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "film_realisateur",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_realisateur")
    )
    private List<Realisateur> realisateurs = new ArrayList<>();

}
