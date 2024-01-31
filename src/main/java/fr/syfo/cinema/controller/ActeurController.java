package fr.syfo.cinema.controller;

import fr.syfo.cinema.dto.ActeurCompletDTO;
import fr.syfo.cinema.dto.ActeurReduitDTO;
import fr.syfo.cinema.model.Acteur;
import fr.syfo.cinema.service.ActeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acteurs")
@CrossOrigin
public class ActeurController {

    private final ActeurService acteurService;

    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping("/all")
    public List<ActeurReduitDTO> findAll(){
        return acteurService.findAll();
    }

    @PostMapping("/save")
    public ActeurCompletDTO save(@RequestBody Acteur acteur){
        return acteurService.save(acteur);
    }

    @DeleteMapping("/delete/{id}")
    public ActeurCompletDTO delete(@PathVariable long id){
        return acteurService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ActeurCompletDTO findById(@PathVariable long id){
        return acteurService.findById(id);
    }

    @PatchMapping("/update")
    public void update(@RequestBody Acteur acteur){
        acteurService.update(acteur);
    }

}
