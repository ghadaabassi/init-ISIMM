package com.example.demo.entities;

import java.io.Serializable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DatabaseFile implements Serializable {
	@Id
    @GeneratedValue
	private Long id;


	private String fileName;

	private String fileType;

	@OneToOne(mappedBy = "employer")
	DemandeConger dc;

	@Lob
	private byte[] data;

	public DatabaseFile() {

	}

	public DatabaseFile(String fileName, String fileType, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

}
