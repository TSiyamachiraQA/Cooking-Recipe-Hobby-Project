package com.qa.dto;

import com.qa.domain.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class RecipesDTO {

    private Long recipeId;
    private String recipeName;
    private Long recipeServing;
    private String description;

    private List<IngredientsDTO> ingredients = new ArrayList<>();

    public RecipesDTO(){}

    public RecipesDTO(String recipeName, Long recipeServing, String description) {
        this.recipeName = recipeName;
        this.recipeServing = recipeServing;
        this.description = description;
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

    public List<IngredientsDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDTO> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipesDTO that = (RecipesDTO) o;

        if (!recipeId.equals(that.recipeId)) return false;
        if (!recipeName.equals(that.recipeName)) return false;
        if (!recipeServing.equals(that.recipeServing)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = recipeId.hashCode();
        result = 31 * result + recipeName.hashCode();
        result = 31 * result + recipeServing.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
