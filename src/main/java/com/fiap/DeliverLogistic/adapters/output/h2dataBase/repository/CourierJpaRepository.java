package com.fiap.DeliverLogistic.adapters.output.h2dataBase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities.CourierEntity;

@Repository
public interface CourierJpaRepository extends JpaRepository<CourierEntity, Long>{
	
	@Query(value = "SELECT * FROM tb_courier WHERE time_online IS NOT NULL ORDER BY time_online ASC", nativeQuery = true)
    List<CourierEntity> findAllCourierByTimeOnlineAsc();

}
