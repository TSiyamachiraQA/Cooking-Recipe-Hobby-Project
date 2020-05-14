package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    private String ingredientName;
    private String ingredientType;

    @ManyToOne(targetEntity = Recipes.class)
    private Recipes recipes;

    public Ingredients(){}

    public Ingredients(String ingredientName, String ingredientType) {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public Ingredients(Long ingredientId, String ingredientName, String ingredientType) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public Recipes getRecipes() { return recipes; }

    public void setRecipes(Recipes recipes) {this.recipes = recipes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return Objects.equals(ingredientId, that.ingredientId) &&
                Objects.equals(ingredientName, that.ingredientName) &&
                Objects.equals(ingredientType, that.ingredientType);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(ingredientId, ingredientName, ingredientType);
//    }
}
