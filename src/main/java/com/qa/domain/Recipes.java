package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;

    private String recipeName;
    private Long recipeServing;
    private String description;

    public Recipes(Long recipeId, String recipeName, Long recipeServing, String description) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeServing = recipeServing;
        this.description = description;
    }

    public Recipes(String recipeName, Long recipeServing, String description) {
        this.recipeName = recipeName;
        this.recipeServing = recipeServing;
        this.description = description;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipes recipes = (Recipes) o;

        if (!recipeId.equals(recipes.recipeId)) return false;
        if (!recipeName.equals(recipes.recipeName)) return false;
        if (!recipeServing.equals(recipes.recipeServing)) return false;
        return description.equals(recipes.description);
    }

    @Override
    public int hashCode() { return Objects.hash(recipeId, recipeName, recipeServing, description);}
}





