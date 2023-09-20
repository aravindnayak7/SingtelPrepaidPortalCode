package com.rest.controller;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rest.controller.PlansController;
//import com.rest.exception.PlanFoundException;
//import com.rest.exception.PlanNotFoundException;
//import com.rest.model.SimPlans;
//import com.rest.service.PlanServiceImpl;
//
//@WebMvcTest(PlansController.class)
//public class PlansControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PlanServiceImpl planService;
//
//    @InjectMocks
//    private PlansController plansController;
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testSavePlanHandler() throws Exception {
//        // Create a sample SimPlans object
//        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");
//
//        // Mock the behavior of the service method
//        when(planService.savePlan(any(SimPlans.class))).thenReturn(samplePlan);
//
//        // Perform a POST request to the "/api/v1/addplan" endpoint
//        mockMvc.perform(post("/api/v1/addplan")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(samplePlan)))
//                .andExpect(status().isCreated()) // Expect HTTP status 201
//                .andExpect(jsonPath("$.planId").value(1)) // Check if the response JSON contains planId
//                .andExpect(jsonPath("$.planName").value("Sample Plan")); // Check if the response JSON contains planName
//    }
//
//    @Test
//    public void testUpdateItemHandler() throws Exception {
//        // Create a sample SimPlans object
//        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");
//
//        // Mock the behavior of the service method
//        when(planService.updatePlanById(any(SimPlans.class), anyInt())).thenReturn(samplePlan);
//
//        // Perform a PUT request to the "/api/v1/updateplan/1" endpoint
//        mockMvc.perform(put("/api/v1/updateplan/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(samplePlan)))
//                .andExpect(status().isCreated()) // Expect HTTP status 201
//                .andExpect(jsonPath("$.planId").value(1)) // Check if the response JSON contains planId
//                .andExpect(jsonPath("$.planName").value("Sample Plan")); // Check if the response JSON contains planName
//    }
//
//    @Test
//    public void testSavePlanByIdHandler() throws Exception {
//        // Create a sample SimPlans object
//        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");
//
//        // Mock the behavior of the service method
//        when(planService.getPlanById(1)).thenReturn(samplePlan);
//
//        // Perform a GET request to the "/api/v1/getplan/1" endpoint
//        mockMvc.perform(get("/api/v1/getplan/1"))
//                .andExpect(status().isCreated()) // Expect HTTP status 201
//                .andExpect(jsonPath("$.planId").value(1)) // Check if the response JSON contains planId
//                .andExpect(jsonPath("$.planName").value("Sample Plan")); // Check if the response JSON contains planName
//    }
//
//    @Test
//    public void testGetAllPlansHandler() throws Exception {
//        // Create a list of sample SimPlans objects
//        List<SimPlans> plansList = new ArrayList<>();
//        plansList.add(new SimPlans(1, "Plan 1", 100, "Details 1", "Description 1"));
//        plansList.add(new SimPlans(2, "Plan 2", 200, "Details 2", "Description 2"));
//
//        // Mock the behavior of the service method
//        when(planService.getAllPlans()).thenReturn(plansList);
//
//        // Perform a GET request to the "/api/v1/getAllPlans" endpoint
//        mockMvc.perform(get("/api/v1/getAllPlans"))
//                .andExpect(status().isOk()) // Expect HTTP status 200
//                .andExpect(jsonPath("$[0].planId").value(1)) // Check if the response JSON contains planId of the first plan
//                .andExpect(jsonPath("$[0].planName").value("Plan 1")) // Check if the response JSON contains planName of the first plan
//                .andExpect(jsonPath("$[1].planId").value(2)) // Check if the response JSON contains planId of the second plan
//                .andExpect(jsonPath("$[1].planName").value("Plan 2")); // Check if the response JSON contains planName of the second plan
//    }
//
//    @Test
//    public void testDeleteByHandler() throws Exception {
//        // Mock the behavior of the service method
//        when(planService.delPlans(1)).thenReturn(true);
//
//        // Perform a DELETE request to the "/api/v1/delete/1" endpoint
//        mockMvc.perform(delete("/api/v1/delete/1"))
//                .andExpect(status().isOk()) // Expect HTTP status 200
//                .andExpect(content().string("true")); // Expect the response content to be "true"
//    }
//
//    @Test
//    public void testGetAllPlanssHandler() throws Exception {
//        // Create a list of sample SimPlans objects
//        List<SimPlans> plansList = new ArrayList<>();
//        plansList.add(new SimPlans(1, "Plan 1", 100, "Details 1", "Description 1"));
//        plansList.add(new SimPlans(2, "Plan 2", 200, "Details 2", "Description 2"));
//
//        // Mock the behavior of the service method
//        when(planService.validateByPlanName("Plan")).thenReturn(plansList);
//
//        // Perform a GET request to the "/api/v1/getplannames/Plan" endpoint
//        mockMvc.perform(get("/api/v1/getplannames/Plan"))
//                .andExpect(status().isOk()) // Expect HTTP status 200
//                .andExpect(jsonPath("$[0].planId").value(1)) // Check if the response JSON contains planId of the first plan
//                .andExpect(jsonPath("$[0].planName").value("Plan 1")) // Check if the response JSON contains planName of the first plan
//                .andExpect(jsonPath("$[1].planId").value(2)) // Check if the response JSON contains planId of the second plan
//                .andExpect(jsonPath("$[1].planName").value("Plan 2")); // Check if the response JSON contains planName
//
// }}       
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.controller.PlansController;
import com.rest.exception.PlanFoundException;
import com.rest.exception.PlanNotFoundException;
import com.rest.model.SimPlans;
import com.rest.service.PlanServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(PlansController.class)
public class PlansControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanServiceImpl planService;

    @InjectMocks
    private PlansController plansController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePlanHandler() throws Exception {
        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");

        when(planService.savePlan(any(SimPlans.class))).thenReturn(samplePlan);

        mockMvc.perform(post("/api/v1/addplan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(samplePlan)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.planId").value(1))
                .andExpect(jsonPath("$.planName").value("Sample Plan"));
    }

    @Test
    public void testUpdateItemHandler() throws Exception {
        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");

        when(planService.updatePlanById(any(SimPlans.class), anyInt())).thenReturn(samplePlan);

        mockMvc.perform(put("/api/v1/updateplan/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(samplePlan)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.planId").value(1))
                .andExpect(jsonPath("$.planName").value("Sample Plan"));
    }

    @Test
    public void testSavePlanByIdHandler() throws Exception {
        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");

        when(planService.getPlanById(1)).thenReturn(samplePlan);

        mockMvc.perform(get("/api/v1/getplan/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.planId").value(1))
                .andExpect(jsonPath("$.planName").value("Sample Plan"));
    }

    @Test
    public void testGetAllPlansHandler() throws Exception {
        List<SimPlans> plansList = new ArrayList<>();
        plansList.add(new SimPlans(1, "Plan 1", 100, "Details 1", "Description 1"));
        plansList.add(new SimPlans(2, "Plan 2", 200, "Details 2", "Description 2"));

        when(planService.getAllPlans()).thenReturn(plansList);

        mockMvc.perform(get("/api/v1/getAllPlans"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].planId").value(1))
                .andExpect(jsonPath("$[0].planName").value("Plan 1"))
                .andExpect(jsonPath("$[1].planId").value(2))
                .andExpect(jsonPath("$[1].planName").value("Plan 2"));
    }

    @Test
    public void testDeleteByHandler() throws Exception {
        when(planService.delPlans(1)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testGetAllPlanssHandler() throws Exception {
        List<SimPlans> plansList = new ArrayList<>();
        plansList.add(new SimPlans(1, "Plan 1", 100, "Details 1", "Description 1"));
        plansList.add(new SimPlans(2, "Plan 2", 200, "Details 2", "Description 2"));

        when(planService.validateByPlanName("Plan")).thenReturn(plansList);

        mockMvc.perform(get("/api/v1/getplannames/Plan"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].planId").value(1))
                .andExpect(jsonPath("$[0].planName").value("Plan 1"))
                .andExpect(jsonPath("$[1].planId").value(2))
                .andExpect(jsonPath("$[1].planName").value("Plan 2"));
    }
}
