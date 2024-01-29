package com.ejemplos.demoJPA.repositories;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejemplos.demoJPA.entities.Empleado;

import jakarta.transaction.Transactional;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
		List<Empleado> findBySalarioGreaterThan(double salMin);
		
		
		@Transactional
		@Modifying
		@Query(value="update empleado set salario=salario + salario * :porc /100 "
				+ "	where id=:id",
				nativeQuery=true				
				)
		public void subirSalario(@Param("id") int id, @Param("porc") int porc);

}
