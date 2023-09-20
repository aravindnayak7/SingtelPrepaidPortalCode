package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.exception.PlanFoundException;
import com.rest.exception.PlanNotFoundException;
import com.rest.model.SimPlans;
import com.rest.service.PlanServiceImpl;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class PlansController {

    @Autowired
    private PlanServiceImpl pservice;

    @PostMapping("/addplan")
    public ResponseEntity<?> savePlanHandler(@RequestBody SimPlans pobj) throws PlanFoundException {
    	SimPlans addplan = pservice.savePlan(pobj);
        return new ResponseEntity<>(addplan, HttpStatus.CREATED);
//        try {
//            SimPlans addplan = pservice.savePlan(pobj);
//            return new ResponseEntity<>(addplan, HttpStatus.CREATED);
//        } catch (PlanFoundException e) {
//            return new ResponseEntity<>("Plan already exists: " + e.getMessage(), HttpStatus.CONFLICT);
//        }
    }

    @PutMapping("/updateplan/{planId}")
    public ResponseEntity<?> updateItemHandler(@RequestBody SimPlans pobj, @PathVariable int planId) throws PlanFoundException {
        SimPlans upplan = pservice.updatePlanById(pobj, planId);
		return new ResponseEntity<>(upplan, HttpStatus.OK);
    }

    @GetMapping("/getplan/{planId}")
    public ResponseEntity<?> getPlanByIdHandler(@PathVariable int planId) throws PlanNotFoundException {
    	SimPlans getplan = pservice.getPlanById(planId);
        return new ResponseEntity<>(getplan, HttpStatus.OK);
//        try {
//            SimPlans getplan = pservice.getPlanById(planId);
//            return new ResponseEntity<>(getplan, HttpStatus.OK);
//        } catch (PlanNotFoundException e) {
//            return new ResponseEntity<>("Plan not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
//        }
    }

    @GetMapping("/getAllPlans")
    public ResponseEntity<List<SimPlans>> getAllPlansHandler() {
        List<SimPlans> getallplans = pservice.getAllPlans();
        return new ResponseEntity<>(getallplans, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<?> deleteByHandler(@PathVariable int planId)throws PlanNotFoundException {
    	 boolean del = pservice.delPlans(planId);
       return new ResponseEntity<>(del, HttpStatus.OK);
//        try {
//            boolean del = pservice.delPlans(planId);
//            return new ResponseEntity<>(del, HttpStatus.OK);
//        } catch (PlanNotFoundException e) {
//            return new ResponseEntity<>("Plan not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
//        }
    }

    @GetMapping("/getplannames/{planName}")
    public ResponseEntity<?> getAllPlansByNameHandler(@PathVariable String planName) throws PlanNotFoundException {
    	List<SimPlans> catitem = pservice.validateByPlanName(planName);
        return new ResponseEntity<>(catitem, HttpStatus.OK);
//        try {
//            List<SimPlans> catitem = pservice.validateByPlanName(planName);
//            return new ResponseEntity<>(catitem, HttpStatus.OK);
//        } catch (PlanNotFoundException e) {
//            return new ResponseEntity<>("Plans not found for name: " + e.getMessage(), HttpStatus.NOT_FOUND);
//        }
    }
}
