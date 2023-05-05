package com.example.demo.gestionConge.exempleEntity;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.DemandeConger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/gestionConge/exempleEntity")
public class CongeEntityController {
    private final CongeEntityServices entityService;

    @Autowired
    public CongeEntityController(CongeEntityServices entityService){
        this.entityService=entityService;
    }

	@PostMapping(path="/add", consumes= {"application/xml", "application/json;charset=UTF-8"})
    public DemandeCongerResponse addDemande(@RequestBody RegisterRequestRecord  c){

        DemandeCongerResponse d = entityService.addDemande(c);

    	return d;
    }

    @GetMapping
    public List<DemandeConger> GetAllDemande(){
    	
		return entityService.GetAllDemande();
	}

    @PostMapping(path="{idDemandeConger}")
    public DemandeCongerResponse updateDemande(@RequestBody RegisterRequestRecord c ,@PathVariable Long idDemandeConger ){
    	
		return entityService.updateDemande(c, idDemandeConger);}

    @DeleteMapping(path="{idDemandeConger}")
    public String deleteDemande(@PathVariable Long idDemandeConger){
    	
		return entityService.deleteDemande(idDemandeConger);}

}
