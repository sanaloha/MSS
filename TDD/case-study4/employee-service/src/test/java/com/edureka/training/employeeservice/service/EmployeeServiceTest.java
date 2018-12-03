package com.edureka.training.employeeservice.service;

import com.edureka.training.employeeservice.model.Employee;
import com.edureka.training.employeeservice.model.EmployeeRequest;
import com.edureka.training.employeeservice.repository.EmployeeRepositroy;
import com.edureka.training.employeeservice.repository.SUT;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeServiceTest {

    @SUT
    EmployeeService employeeService;

    @Before
    public void setUp(){
        employeeService = new EmployeeService();
        employeeService.employeeRepositroy = Mockito.mock(EmployeeRepositroy.class);

    }
    @Test
    public void shouldEnsureInteractionWithRepositoryWhenSaved(){

        //Given
        EmployeeRequest employeeRequest = EmployeeRequest.builder()
                                            .id(1).name("santosh").designation("Associate")
                                            .salary(50000).build();

        Employee employee = Employee.builder().id(employeeRequest.getId())
                            .name(employeeRequest.getName()).designation(employeeRequest.getDesignation())
                            .salary(employeeRequest.getSalary()).build();

        Mockito.when(employeeService.employeeRepositroy.save(Mockito.any(Employee.class))).thenReturn(employee);

        //When -if saved
        boolean isSaved = employeeService.save(employeeRequest);

        //Then - Repository save is called
        Assertions.assertThat(isSaved).isEqualTo(true);
        Mockito.verify(employeeService.employeeRepositroy,Mockito.times(1)).save(Mockito.any(Employee.class));
        Mockito.verify(employeeService.employeeRepositroy,Mockito.never()).findAll();


    }
}