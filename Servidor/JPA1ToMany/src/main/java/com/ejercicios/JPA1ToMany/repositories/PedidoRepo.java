package com.ejercicios.JPA1ToMany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicios.JPA1ToMany.entities.Pedido;

@Repository
public interface PedidoRepo extends JpaRepository<Pedido,Integer> {

}
