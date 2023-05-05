package com.example.demo.gestionConge.exempleEntity;

import com.example.demo.entities.DemandeConger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemandeCongerResponse {
    private DemandeConger dm;
}
