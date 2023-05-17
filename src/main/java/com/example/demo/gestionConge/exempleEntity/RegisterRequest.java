package com.example.demo.gestionConge.exempleEntity;

import com.example.demo.entities.DatabaseFile;
import com.example.demo.entities.Employer;
import com.example.demo.entities.enums.Etat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String type ;
    private String Justification;
    private Date DateDebut;
    private Date DateFin;
    private Employer employer;
    private DatabaseFile df;
    private Etat etatDemande=Etat.ATTENTE;
}
