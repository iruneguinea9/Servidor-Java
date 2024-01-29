package com.example.hospital.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hospital.entities.Medico;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	@Query (value="select * from medico",			
			nativeQuery=true)
	public ArrayList<String> medicos();
}
