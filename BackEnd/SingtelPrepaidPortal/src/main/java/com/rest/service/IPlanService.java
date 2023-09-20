package com.rest.service;

import java.util.List;

import com.rest.exception.PlanFoundException;
import com.rest.exception.PlanNotFoundException;
import com.rest.model.SimPlans;

public interface IPlanService {
	public SimPlans savePlan(SimPlans pobj)throws PlanFoundException;
	public SimPlans getPlanById(int planId)throws PlanNotFoundException;
	public SimPlans updatePlanById(SimPlans pobj,int planId)throws PlanFoundException;
	public List<SimPlans> getAllPlans();
	public boolean delPlans(int planId)throws PlanNotFoundException;
	public List<SimPlans> validateByPlanName(String planName)throws PlanNotFoundException;
}
