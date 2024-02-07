package com.gym_backend.api;

import com.gym_backend.dto.MembreDto;
import com.gym_backend.dto.PaimentDto;
import com.gym_backend.models.Membre;
import com.gym_backend.repository.MembreRepository;
import com.gym_backend.services.MembreService;
import com.gym_backend.services.Impl.MembreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/membres")
@RequiredArgsConstructor
public class MembreController {

    @Autowired
    private final MembreService membreService;
    @Autowired
    private final MembreRepository membreRepository;

    @GetMapping("id/{id}")
    public Optional<Membre> findById(@PathVariable Long id){

        return membreService.findById_membre(id);
    }

    @GetMapping("all")
    private Optional<List<Membre>> afficher(){
        return membreService.findAll();
    }

    @PostMapping("save/{email}")
    private ResponseEntity<String> ajouter(@PathVariable String email, @RequestBody MembreDto membredto){

        if (membreRepository.existsByEmail(membredto.getEmail())) {
            return new ResponseEntity<>("nok", HttpStatus.FOUND);
        }
        else{
            membreService.addMembre(email, membredto);
            return new ResponseEntity<>("ok", HttpStatus.CREATED);
        }
        }

     @PutMapping("edit/{id}")
     private ResponseEntity<String> editer(@RequestBody MembreDto membreDto, @PathVariable Long id){
         if (membreService.updateMembre(membreDto, id)) {
                 return new ResponseEntity<>("Member Updated", HttpStatus.ACCEPTED);
         }
         else return new ResponseEntity<>("Error occured", HttpStatus.CREATED);
        }

    @GetMapping("statut/{statut}")
    private Optional<List<Membre>> getByStatut(@PathVariable("statut") String statut){
        return membreService.findByStatut(statut);
    }
    @GetMapping("nom/{nom}")
    private Optional<List<Membre>> getByName(@PathVariable String nom){
        return  membreService.findByName(nom);
    }

    @GetMapping("email/{email}")
    private Optional<Membre> getByEmail(@PathVariable String email){
        return membreService.findByEmail(email);
    }

    @PostMapping("/add_payment/{id}")
    private ResponseEntity<String> ajouter_payment(@RequestBody PaimentDto paimentDto, @PathVariable Long id){
        if (membreService.addPayment(paimentDto, id)) {
            return new ResponseEntity<>("Paiement Validé", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Une erreur s'est produite", HttpStatus.BAD_REQUEST);
    }
}
