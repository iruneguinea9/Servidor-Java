package com.example.eventos.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventos.entities.Venta;

@Repository
public interface VentaRepo extends JpaRepository<Venta,Integer> {

    ArrayList<Venta> findByComprador(String comprador);
    ArrayList<Venta> findByEventoId(Integer id);
    void deleteByEventoId(Integer id);
} 