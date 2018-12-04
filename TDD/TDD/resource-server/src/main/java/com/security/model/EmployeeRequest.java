package com.security.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeRequest {

    Integer id;
    String name;
    String designation;
    Integer salary;
}
