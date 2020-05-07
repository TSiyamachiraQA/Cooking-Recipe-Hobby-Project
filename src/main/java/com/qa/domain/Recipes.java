package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;

    private String recipeName;
    private Long recipeServing;
    private String description;

    @OneToMany(mappedBy = "recipes", fetch = FetchType.LAZY)
    private List<Ingredients> ingredients = new ArrayList<>();

    public Recipes(){}

    public Recipes(String recipeName) {
        this.recipeName = recipeName;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Long getRecipeServing() {
        return recipeServing;
    }

    public void setRecipeServing(Long recipeServing) {
        this.recipeServing = recipeServing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
