package com.example.demo.Doa;

import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.Employer;
import com.example.demo.entities.enums.Cause;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeCongerRepository extends JpaRepository<DemandeConger, Long> {


    List <DemandeConger> findByTypeAndEmployer(Cause type , Employer employer);
    List <DemandeConger> findByEmployer(Employer employer);

}