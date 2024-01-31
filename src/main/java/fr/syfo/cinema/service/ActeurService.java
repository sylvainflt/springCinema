package fr.syfo.cinema.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.syfo.cinema.dto.ActeurCompletDTO;
import fr.syfo.cinema.dto.ActeurReduitDTO;
import fr.syfo.cinema.exceptions.NotFoundException;
import fr.syfo.cinema.model.Acteur;
import fr.syfo.cinema.repository.ActeurRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActeurService {

    private final ActeurRepository acteurRepository;

    private final ObjectMapper objectMapper;

    public ActeurService(ActeurRepository acteurRepository, ObjectMapper objectMapper) {
        this.acteurRepository = acteurRepository;
        this.objectMapper = objectMapper;
    }

    public List<ActeurReduitDTO> findAll(){
        List<Acteur> acteurs = acteurRepository.findAll();
        return acteurs
                .stream()
                .map(acteur -> objectMapper.convertValue(acteur, ActeurReduitDTO.class))
                .toList();
    }

    public ActeurCompletDTO findById(Long id){
        Acteur acteur = acteurRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Acteur avec id "+id+" non trouvé")
        );
        return objectMapper.convertValue(acteur, ActeurCompletDTO.class);
    }

    public ActeurCompletDTO save(Acteur acteur){
        Acteur acteurToSave = acteurRepository.save(acteur);
        return objectMapper.convertValue(acteurToSave, ActeurCompletDTO.class);
    }

    public ActeurCompletDTO deleteById(Long id){
        ActeurCompletDTO acteur = findById(id);
        acteurRepository.deleteById(id);
        return acteur;
    }

    public void deleteAll(){
        acteurRepository.deleteAll();
    }

    public void update(Acteur acteur){
        acteurRepository.save(acteur);
    }

}
