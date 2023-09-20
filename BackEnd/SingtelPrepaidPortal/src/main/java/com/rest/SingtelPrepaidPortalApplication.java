package com.rest;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
@EnableScheduling
@SpringBootApplication
public class SingtelPrepaidPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingtelPrepaidPortalApplication.class, args);
	}
	@Scheduled(cron="0 0/30 9-18 * * *")
	public void activatePort() {
    	int currentYear = LocalDate.now().getYear();
        int currentMin = LocalTime.now().getMinute();
    
        LocalDate currentDate = LocalDate.now();
        if(currentYear==2023){
        	System.out.println("\"Dear user, your port has been activated, and you can now enjoy uninterrupted service.\"\n"
        			+ "\n"
        			+ "\n"
        			+ "\n"
        			+ "\n"
        			+ ""+ currentDate);
        }
    }
	@Scheduled(cron="* * 9-18 * JAN-DEC 1")
	public void scheduledTask1() {
    	int currentYear = LocalDate.now().getYear();
        int currentMin = LocalTime.now().getMinute();
    
        LocalDate currentDate = LocalDate.now();
        if(currentYear==2023&& currentMin==17){
        	System.out.println("Dear user, your plan is expiring soon. Please recharge with one of the available plans to continue enjoying uninterrupted services."+ currentDate);
        }
    }
	
	@Scheduled(cron="* * 9-18 * JAN-DEC 2")
	public void scheduledTask2() {
    	int currentYear = LocalDate.now().getYear();
        int currentMin = LocalTime.now().getMinute();
    
        LocalDate currentDate = LocalDate.now();
        if(currentYear==2023&& currentMin==17){
        	System.out.println("Your incoming calls and data services have been suspended because your data pack has been depleted. To restore these services, please initiate a recharge."+ currentDate);
        }
    }
	@Scheduled(cron="* * 9-18 * JAN-DEC 3")
	public void scheduledTask3() {
    	int currentYear = LocalDate.now().getYear();
        int currentMin = LocalTime.now().getMinute();
    
        LocalDate currentDate = LocalDate.now();
        if(currentYear==2023&& currentMin==17){
        	System.out.println("\"Your upcoming offers include unlimited calls and extended data services.\""+ currentDate);
        }
    }
	
	
}
