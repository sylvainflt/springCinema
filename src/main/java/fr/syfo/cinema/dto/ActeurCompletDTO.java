package fr.syfo.cinema.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurCompletDTO {

    private Long id;

    private String nom;

    private String prenom;

    private List<FilmReduitDTO> films = new ArrayList<>();
}
