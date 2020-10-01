package com.acme.homemade.demo.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
