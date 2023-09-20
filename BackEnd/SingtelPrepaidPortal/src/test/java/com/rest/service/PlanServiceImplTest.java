package com.rest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rest.exception.PlanFoundException;
import com.rest.exception.PlanNotFoundException;
import com.rest.model.SimPlans;
import com.rest.repository.PlansRepository;

public class PlanServiceImplTest {

    @InjectMocks
    private PlanServiceImpl planService;

    @Mock
    private PlansRepository plansRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePlan() throws PlanFoundException {
        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");
        when(plansRepository.findById(1)).thenReturn(Optional.empty());
        when(plansRepository.save(samplePlan)).thenReturn(samplePlan);

        SimPlans savedPlan = planService.savePlan(samplePlan);

        assertEquals(samplePlan, savedPlan);
    }

    @Test
    public void testGetPlanById() throws PlanNotFoundException {
        SimPlans samplePlan = new SimPlans(1, "Sample Plan", 100, "Sample details", "Sample description");
        when(plansRepository.findById(1)).thenReturn(Optional.of(samplePlan));

        SimPlans retrievedPlan = planService.getPlanById(1);

        assertEquals(samplePlan, retrievedPlan);
    }

    @Test
    public void testUpdatePlanById() throws PlanFoundException {
        SimPlans existingPlan = new SimPlans(1, "Existing Plan", 100, "Existing details", "Existing description");
        SimPlans updatedPlanData = new SimPlans(1, "Updated Plan", 200, "Updated details", "Updated description");
        when(plansRepository.findById(1)).thenReturn(Optional.of(existingPlan));
        when(plansRepository.save(existingPlan)).thenReturn(existingPlan);

        SimPlans updatedPlan = planService.updatePlanById(updatedPlanData, 1);

        assertEquals(updatedPlanData.getPlanName(), updatedPlan.getPlanName());
        assertEquals(updatedPlanData.getPlanCost(), updatedPlan.getPlanCost());
        assertEquals(updatedPlanData.getPlanDetails(), updatedPlan.getPlanDetails());
        assertEquals(updatedPlanData.getPlanDescription(), updatedPlan.getPlanDescription());
    }

    @Test
    public void testGetAllPlans() {
        List<SimPlans> plansList = new ArrayList<>();
        plansList.add(new SimPlans(1, "Plan 1", 100, "Details 1", "Description 1"));
        plansList.add(new SimPlans(2, "Plan 2", 200, "Details 2", "Description 2"));
        when(plansRepository.findAll()).thenReturn(plansList);

        List<SimPlans> retrievedPlans = planService.getAllPlans();

        assertEquals(plansList, retrievedPlans);
    }

    @Test
    public void testDelPlans() throws PlanNotFoundException {
        when(plansRepository.findById(1)).thenReturn(Optional.of(new SimPlans(1, "Plan 1", 100, "Details 1", "Description 1")));

        boolean isDeleted = planService.delPlans(1);

        assertTrue(isDeleted);
        verify(plansRepository, times(1)).delete(any());
    }

    @Test
    public void testDelPlansPlanNotFoundException() {
        when(plansRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(PlanNotFoundException.class, () -> planService.delPlans(1));
    }

    @Test
    public void testValidateByPlanName() throws PlanNotFoundException {
        List<SimPlans> plansList = new ArrayList<>();
        plansList.add(new SimPlans(1, "Plan 1", 100, "Details 1", "Description 1"));
        plansList.add(new SimPlans(2, "Plan 2", 200, "Details 2", "Description 2"));
        when(plansRepository.findByPlanName("Plan")).thenReturn(plansList);

        List<SimPlans> retrievedPlans = planService.validateByPlanName("Plan");

        assertEquals(plansList, retrievedPlans);
    }

    @Test
    public void testValidateByPlanNamePlanNotFoundException() {
        when(plansRepository.findByPlanName("Plan")).thenReturn(new ArrayList<>());

        assertThrows(PlanNotFoundException.class, () -> planService.validateByPlanName("Plan"));
    }
}
