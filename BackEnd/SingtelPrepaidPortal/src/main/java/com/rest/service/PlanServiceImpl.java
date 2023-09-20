package com.rest.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.exception.PlanFoundException;
import com.rest.exception.PlanNotFoundException;
import com.rest.model.SimPlans;
import com.rest.repository.PlansRepository;
@Service
public class PlanServiceImpl implements IPlanService {
	private final Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);
	@Autowired
	private PlansRepository prepo;
	@Override
	public SimPlans savePlan(SimPlans pobj) throws PlanFoundException {
		// TODO Auto-generated method stub
		Optional<SimPlans> saveplan=this.prepo.findById(pobj.getPlanId());
		SimPlans addplan=null;
		if(saveplan.isPresent()) {
//			throw new PlanFoundException();
			System.out.println("plan foundexception");
		}else {
			addplan=this.prepo.save(pobj);
		}
		return addplan;
	}

	@Override
	public SimPlans getPlanById(int planId) throws PlanNotFoundException {
		// TODO Auto-generated method stub
		Optional<SimPlans> getplan=this.prepo.findById(planId);
		SimPlans display=null;
		if(getplan.isPresent()) {
			display=getplan.get();
		}else {
			throw new PlanNotFoundException();
		}
		
		return display;
	}

	@Override
	public SimPlans updatePlanById(SimPlans pobj, int planId) throws PlanFoundException {
		// TODO Auto-generated method stub
		Optional<SimPlans> upplans=this.prepo.findById(planId);
		SimPlans addplan=null;
		SimPlans updatedata=null;
		if(upplans.isPresent()) {
			addplan=upplans.get();
			addplan.setPlanCost(pobj.getPlanCost());
			addplan.setPlanDescription(pobj.getPlanDescription());;
			addplan.setPlanDetails(pobj.getPlanDetails());;
			addplan.setPlanName(pobj.getPlanName());;
			updatedata=this.prepo.save(addplan);
		}else {
			throw new PlanFoundException();
		}
		return updatedata;
	}

	@Override
	public List<SimPlans> getAllPlans() {
		// TODO Auto-generated method stub
		return this.prepo.findAll();
	}

	@Override
	public boolean delPlans(int planId) throws PlanNotFoundException {
		// TODO Auto-generated method stub
		Optional<SimPlans> del=this.prepo.findById(planId);
		boolean status=false;
		if(del.isPresent()) {
			this.prepo.delete(del.get());
		}else {
			throw new PlanNotFoundException();
		}
		return true;
	}

	@Override
	public List<SimPlans> validateByPlanName(String planName) throws PlanNotFoundException {
		// TODO Auto-generated method stub
		List<SimPlans> cat=this.prepo.findByPlanName(planName);
		if(cat.isEmpty()) {
			throw new PlanNotFoundException();
		}
		return cat;
	}

}
