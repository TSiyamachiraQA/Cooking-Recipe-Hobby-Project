package com.qa.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class IngredientInRecipes {

    @EmbeddedId
    IngredientsInRecipesKey id;

    @ManyToOne
    @MapsId("ingredients_ingredient_id")
    @JoinColumn(name = "ingedient_id")
    Ingredients  ingredients;

    @ManyToOne
    @MapsId("recipes_recipe_id")
    @JoinColumn(name = "recipe_id")
    Recipes  recipes;

    public IngredientsInRecipesKey getId() {
        return id;
    }

    public void setId(IngredientsInRecipesKey id) {
        this.id = id;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Recipes getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }

}
