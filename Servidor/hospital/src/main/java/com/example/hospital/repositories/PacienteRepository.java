package com.example.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entities.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

}
