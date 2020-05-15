package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class IngredientsInRecipesKey implements Serializable {

    @Column(name = "Ingredients_ingredientsID")
    Long ingredientId;

    @Column(name = "Recipes_recipeID")
    Long recipeId;

    public IngredientsInRecipesKey(Long ingredientId, Long recipeId) {
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientsInRecipesKey that = (IngredientsInRecipesKey) o;

        if (!ingredientId.equals(that.ingredientId)) return false;
        return recipeId.equals(that.recipeId);
    }

    @Override
    public int hashCode() {
        int result = ingredientId.hashCode();
        result = 31 * result + recipeId.hashCode();
        return result;
    }
}