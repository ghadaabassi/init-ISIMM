package com.example.demo.gestionConge.exempleEntity;

import com.example.demo.entities.enums.Cause;
import com.example.demo.entities.enums.Etat;
import com.example.demo.entities.enums.TypeCongé;

import java.util.Date;

public record RegisterRequestRecord(Cause type , TypeCongé Typecongé, String Justification, Date DateDebut, Date DateFin, Etat etatDemande, Long employe ){}