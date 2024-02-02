package com.ejercicios.JPA1ToMany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicios.JPA1ToMany.entities.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

}
