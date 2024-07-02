import org.emp.controller.EmpController;
import org.emp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService service;

    @InjectMocks
    private EmpController controller;

    @Test
    public void testDeleteEmployee() {
        // Mock the service method to do nothing (since delete operation)
        doNothing().when(service).deleteEmployeeById(any(Long.class));

        // Call the controller method
        String result = controller.deleteEmployee(1L); // Replace with actual ID

        // Verify that the service method was called with the correct ID
        verify(service).deleteEmployeeById(1L); // Replace with actual ID

        // Assert that the controller method returned "Deleted"
        assertEquals("Deleted", result);
    }
}
