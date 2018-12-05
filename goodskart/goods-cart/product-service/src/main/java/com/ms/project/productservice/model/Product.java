package com.ms.project.productservice.model;
import lombok.*;

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
@Table(name="product", catalog = "mssupply")
public class Product {

    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;

}
