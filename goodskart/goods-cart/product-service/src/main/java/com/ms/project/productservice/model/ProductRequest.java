package com.ms.project.productservice.model;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductRequest {
    Integer id;

    String name;

    String description;
}
