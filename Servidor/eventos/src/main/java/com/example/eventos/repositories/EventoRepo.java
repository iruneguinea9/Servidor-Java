package com.example.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventos.entities.Evento;


@Repository
public interface EventoRepo extends JpaRepository<Evento,Integer> {

}
