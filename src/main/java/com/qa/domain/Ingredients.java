package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Ingredients extends IngredientInRecipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;

    private String ingredientName;
    private String ingredientType;

    @OneToMany(mappedBy = "ingredients")
    Set<IngredientInRecipes> ingQuantity;

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

    public Set<IngredientInRecipes> getIngQuantity() {
        return ingQuantity;
    }

    public void setIngQuantity(Set<IngredientInRecipes> ingQuantity) {
        this.ingQuantity = ingQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return Objects.equals(ingredientId, that.ingredientId) &&
                Objects.equals(ingredientName, that.ingredientName) &&
                Objects.equals(ingredientType, that.ingredientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, ingredientName, ingredientType);
    }
}
