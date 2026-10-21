package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "planet")
@Data
public class Planet {

    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;

    @Column(name = "name", length = 500, nullable = false)
    private String name;
}