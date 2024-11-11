package tn.esprit.microservice.reclamation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamation")
public class ReclamationRestAPI {

    private String test = "test";
    @Autowired
    private ReclamationService reclamationService;

    @GetMapping("/test")
    public String test() {
        return test;
    }


    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }

    @GetMapping("/{id}")
    public Reclamation getReclamationById(@PathVariable int id) {
        return reclamationService.getReclamationById(id);
    }

    @PostMapping
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }

    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable int id) {
        reclamationService.deleteReclamation(id);
    }

}


