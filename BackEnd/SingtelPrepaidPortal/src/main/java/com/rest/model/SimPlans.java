package com.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class SimPlans {
	@GeneratedValue
	@Id
	private int planId;
	private String planName;
	private int planCost;
	private String planDetails;
	private String planDescription;
	public SimPlans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SimPlans(int planId, String planName, int planCost, String planDetails, String planDescription) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planCost = planCost;
		this.planDetails = planDetails;
		this.planDescription = planDescription;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getPlanCost() {
		return planCost;
	}
	public void setPlanCost(int planCost) {
		this.planCost = planCost;
	}
	public String getPlanDetails() {
		return planDetails;
	}
	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
//	@Override
//	public String toString() {
//		return "SimPlans [planId=" + planId + ", planName=" + planName + ", planCost=" + planCost + ", planDetails=" + planDetails + ", planDescription=" + planDescription + "]";
//	}
	@Override
	public String toString() {
	    return "SimPlans{" +
	            "planId=" + planId +
	            ", planName='" + planName + '\'' +
	            ", planCost=" + planCost +
	            ", planDetails='" + planDetails + '\'' +
	            ", planDescription='" + planDescription + '\'' +
	            '}';
	}
}


