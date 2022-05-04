package com.vio.victor.supermarketservice.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "employees", schema = "sch_supermarket")
@Entity
public class Employee extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq-gen")
    private Long id;
    private String name;
    private LocalDate birth;
    private String cpf;
}
