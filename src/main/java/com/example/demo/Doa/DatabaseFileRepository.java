package com.example.demo.Doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.DatabaseFile;



@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {
    DatabaseFile findByFileName(String name);
}