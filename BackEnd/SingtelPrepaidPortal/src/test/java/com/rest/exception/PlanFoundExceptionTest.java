package com.rest.exception;

import com.rest.exception.PlanFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlanFoundExceptionTest {

    @Test
    public void testPlanFoundException() {
        // Use assertThrows to verify that PlanFoundException is thrown
        assertThrows(PlanFoundException.class, () -> {
            throw new PlanFoundException();
        });
    }
}
