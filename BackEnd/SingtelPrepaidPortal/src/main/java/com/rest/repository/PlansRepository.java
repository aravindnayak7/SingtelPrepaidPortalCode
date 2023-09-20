package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.model.SimPlans;

@Repository
public interface PlansRepository extends JpaRepository<SimPlans, Integer>{
	@Query("SELECT i From SimPlans i WHERE i.planName=?1")
List<SimPlans> findByPlanName(String planName);
}
