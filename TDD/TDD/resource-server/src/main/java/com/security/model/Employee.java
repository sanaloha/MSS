package com.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "employee", catalog = "msemployee")
public class Employee {

    @Id
    @Column(name = "id",nullable = false)
    Integer id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "designation")
    String designation;

    @Column(name = "salary")
    Integer salary;
}

/*public class Employee {

    String id;
    String name;
    
    public String getId() {
        return id;
    }

    public void setId(String empId) {
        this.id = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + id + ", empName=" + name + "]";
    }
    //String designation;
    //Integer salary;
}*/
