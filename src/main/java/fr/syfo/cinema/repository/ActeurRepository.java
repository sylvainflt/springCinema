package fr.syfo.cinema.repository;

import fr.syfo.cinema.model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long> {
}
