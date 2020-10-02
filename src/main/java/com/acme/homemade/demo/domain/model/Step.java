package com.acme.homemade.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "steps")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private  String text;

    private  String imagen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonIgnore
    private Recipe recipe;


    public Long getId() {
        return id;
    }

    public Step setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Step setText(String text) {
        this.text = text;
        return this;
    }

    public String getImagen() {
        return imagen;
    }

    public Step setImagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Step setRecipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }
}
