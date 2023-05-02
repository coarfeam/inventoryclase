package com.eamapp.inventoryclase.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(
        name = "category",
        indexes = {@Index(name = "index_name", columnList = "name", unique = true)})
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 8221641001387983699L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}
