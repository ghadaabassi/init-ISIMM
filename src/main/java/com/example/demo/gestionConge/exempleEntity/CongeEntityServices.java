package com.example.demo.gestionConge.exempleEntity;

import com.example.demo.Doa.EmployerRepository;
import com.example.demo.entities.enums.Cause;
import com.example.demo.entities.enums.TypeCongé;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Doa.DemandeCongerRepository;
import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.Employer;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.StaffAdministratif;



@Service
@AllArgsConstructor
public class CongeEntityServices {
	
	@Autowired
	private  DemandeCongerRepository demandeCongerRepository;
	private EmployerRepository employerRepository;


    public DemandeCongerResponse addDemande(@RequestBody RegisterRequestRecord c){


		Employer employer = employerRepository.findById(c.employe())
				.orElseThrow(() -> new EntityNotFoundException("Employe not found"));
	    var d  = DemandeConger.builder()
			  .type(Cause.valueOf(c.type().toString()))
			  .typecongé(TypeCongé.valueOf(c.Typecongé().toString()))
			  .justification(c.Justification())
			  .dateDebut(c.DateDebut())
			  .dateFin(c.DateFin())
			   .employer(employer)
			  .build();


	   if (d.getDateDebut() == null  ) {
		throw new IllegalArgumentException("La date Debut est null ");
   }


   if ( d.getDateFin() == null ) {
	throw new IllegalArgumentException("La date Fin est invalide");
}

if (d.getJustification() == null ) {
	throw new IllegalArgumentException("La Justification est invalide");
}

if ( d.getType() ==null) {
	throw new IllegalArgumentException("Cause est invalide");
}

if (d.getTypecongé()==null) {
	throw new IllegalArgumentException("Le Tupe de Conge est invalide");
}

        if (  d.getDateDebut().after(d.getDateFin())) {
            throw new IllegalArgumentException("La date de début doit être avant la date de fin");
        }


        long differenceMillis = Math.abs(d.getDateFin().getTime() - d.getDateDebut().getTime());
       long nbJoursDemande = TimeUnit.DAYS.convert(differenceMillis, TimeUnit.MILLISECONDS);

        if(employer.getNbJourCongeRestant() <nbJoursDemande &&  d.getType().equals("ANNUEL") ) {   throw new IllegalArgumentException("Nombre de Jours demande est superieure a celui de jours restants ");
       }

	     if(employer instanceof Enseignant) {}
         if(employer instanceof StaffAdministratif) {}

		 employer.addDemandeConger(d);
    	var dc =  demandeCongerRepository.save(d);

		return DemandeCongerResponse.builder()
				.dm(dc)
				.build();
    } 
    
    public List<DemandeConger> GetAllDemande(){
    	
		return demandeCongerRepository.findAll();
	}


public DemandeCongerResponse updateDemande(@RequestBody RegisterRequestRecord c ,@PathVariable Long idDemandeConger ){
    	
String dl=deleteDemande(idDemandeConger);

if (dl.equals("Demande deleted with success !")){
return  addDemande(c);
}
else{
	return null;
}
	}

    public String deleteDemande(@PathVariable Long idDemandeConger){
		if(! demandeCongerRepository.existsById(idDemandeConger)) {
			return "Demande not exist with id: " + idDemandeConger;
		}
		demandeCongerRepository.deleteById(idDemandeConger);
		return "Demande deleted with success !";	
    	
		}

}
