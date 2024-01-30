package com.example.hospital.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entities.Consulta;
import com.example.hospital.entities.Medico;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

	 List<Consulta> findByMedico(Medico medico);

}
