package com.example.hospital.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hospital.entities.Medico;

import jakarta.transaction.Transactional;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	@Query (value="select * from medico",			
			nativeQuery=true)
	public ArrayList<String> medicos();
	
	@Transactional
	@Modifying
	@Query(value="update medico set user=:user,password=:password"
			+ "	where id=:id",
			nativeQuery=true				
			)
	public void actualizarDatos(@Param("id") int id, @Param("user") String user, @Param("password") String password);

	Medico findByUser(String user);
}
