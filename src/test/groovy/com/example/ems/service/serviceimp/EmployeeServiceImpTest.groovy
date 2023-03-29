package com.example.ems.service.serviceimp;

import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.assertj.core.api.Assertions
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

import static org.mockito.BDDMockito.given
import static org.mockito.BDDMockito.willDoNothing
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImpTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeServiceImp underTest;
    private Employee employee;

    @BeforeEach
    void setUp(){
        underTest = new EmployeeServiceImp(employeeRepository);
    }

    @DisplayName("JUnit test for SaveEmployee method")
    @Test
    void saveEmployee() {
        underTest.saveEmployee(employee);

        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save((employeeArgumentCaptor.capture()));

        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        Assertions.assertThat(capturedEmployee).isEqualTo(employee);
    }

    @Test
    void getAllEmployee() {
        underTest.getAllEmployee();
        verify(employeeRepository).findAll();
    }


    @DisplayName("JUnit test for getEmployeeById method")
    @Test
    void getEmployeeByID() {
        employee = new Employee(id: "emp-01", firstName: "Umesh", lastName: "Yadav", email: "umeshyadav@gmail.com");
        underTest.saveEmployee(employee);
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));
        // when
        Employee savedEmployee = underTest.getEmployeeByID(employee.getId());
        // then
        Assertions.assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("JUnit test for updateEmployee method")
    @Test
    void updateEmployee() {

        Employee employee = new Employee(id:"emp-01",firstName: "Tony", lastName: "Tony", email: "tony@gmail.com");
        underTest.saveEmployee(employee);
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));
        given(employeeRepository.save(employee)).willReturn(employee);

        employee.setEmail("ram@gmail.com");
        employee.setFirstName("Ram");
        // when -  action or the behaviour that we are going test
        Employee updatedEmployee = underTest.updateEmployee(employee,employee.getId());

        // then - verify the output
        Assertions.assertThat(updatedEmployee.getEmail()).isEqualTo("ram@gmail.com");
        Assertions.assertThat(updatedEmployee.getFirstName()).isEqualTo("Ram");
    }

    @DisplayName("JUnit test for deleteEmployee method")
    @Test
    void deleteEmployee() {
        // given - precondition or setup
        Employee employee = new Employee(id:"emp-01",firstName: "Tony", lastName: "Tony", email: "tony@gmail.com");
        String employeeId = employee.getId();
        willDoNothing().given(employeeRepository).deleteById(employeeId);
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));

        // when -  action or the behaviour that we are going test
        underTest.deleteEmployee(employeeId);

        // then - verify the output
        verify(employeeRepository,times(1)).deleteById(employeeId);
    }

    @DisplayName("JUnit test for getAllEmployee method")
    @Test
    void findPaginated() {
        Pageable pageable = PageRequest.of(0,5);
        List<Employee> employeeList = new ArrayList<>();
        Page<Employee> page = new PageImpl<>(employeeList, pageable ,employeeList.size());

        given(employeeRepository.findAll(pageable)).willReturn(Optional.of(page) as Page<Employee>)
        underTest.findPaginated(0,5);
        verify(employeeRepository).findAll(PageRequest.of(0,5));
    }
}