package com.qa.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    private String ingredientName;
    private String ingredientType;


    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.EAGER)
     private final List<Recipes> recipes = new ArrayList<>();

    public Ingredients(Long ingredientId, String ingredientName, String ingredientType) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public Ingredients(String ingredientName, String ingredientType) {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public Ingredients() {}

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

    public List<Recipes> getRecipes() {
        return recipes;
    }


    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                ", ingredientType='" + ingredientType + '\'' +
                ", recipes=" + recipes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredients that = (Ingredients) o;

        if (!ingredientId.equals(that.ingredientId)) return false;
        if (!ingredientName.equals(that.ingredientName)) return false;
        if (!ingredientType.equals(that.ingredientType)) return false;
        return recipes.equals(that.recipes);
    }

    @Override
    public int hashCode() {
        int result = ingredientId.hashCode();
        result = 31 * result + ingredientName.hashCode();
        result = 31 * result + ingredientType.hashCode();
        result = 31 * result + recipes.hashCode();
        return result;
    }
}
