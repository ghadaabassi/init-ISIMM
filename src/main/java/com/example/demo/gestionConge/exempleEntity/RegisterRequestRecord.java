package com.example.demo.gestionConge.exempleEntity;

import com.example.demo.entities.enums.Cause;
import com.example.demo.entities.enums.Etat;


import java.util.Date;

public record RegisterRequestRecord(Cause type , String Justification, Date DateDebut, Date DateFin, Etat etatDemande, Long employe , Long df ){}