package com.ejemplos.demoJPA.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ejemplos.demoJPA.entities.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, String> {

	@Query (value="select distinct nombre from ciudad",			
			nativeQuery=true)
	public ArrayList<String> nombres_ciudades();
	
	
}
