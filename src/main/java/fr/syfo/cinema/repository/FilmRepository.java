package fr.syfo.cinema.repository;

import fr.syfo.cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {


}
