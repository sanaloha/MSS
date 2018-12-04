package com.security.repository;
import com.security.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class EmployeeRepositoryTest {

	/*  @SUT
    @Autowired
    EmployeeRepositroy employeeRepositroy;

    @Test
    //Should-Then-Given-When(Optional)
    public void should_SaveEmployee_Given_Employee(){

        //Given
        Employee employee = Employee.builder().id(1)
                            .name("SAN").designation("Associate")
                            .salary(50000).build();

        //When
        employeeRepositroy.save(employee);

        //Then
        Optional<Employee> byId = employeeRepositroy.findById(1);
        Assertions.assertThat(byId.isPresent());
        Assertions.assertThat(employeeRepositroy.count()).isEqualTo(1);
        Assertions.assertThat(byId.get()).isEqualTo(employee);
    }

    @Test
    public void should_NotSaveAnEmployee_GivenAnInvalidEmployee_EmpIdNull(){

        //Given
        Employee employee = Employee.builder().id(2)
                .name(null).designation("Associate")
                .salary(50000).build();

        //when
          try{
              employeeRepositroy.save(employee);
            Assertions.assertThat(false);
        }catch (Exception e){
            Assertions.assertThat(true);
        }

        //Then
        Assertions.assertThat(employeeRepositroy.findById(2)).isEqualTo(0);


    }*/
}