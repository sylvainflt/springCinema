package fr.syfo.cinema.repository;

import fr.syfo.cinema.model.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {
}
