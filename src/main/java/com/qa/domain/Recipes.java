package com.qa.domain;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "recipes")
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    private String recipeName;
    private Long recipeServing;
    private String description;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingredients_recipes",
            joinColumns = {
                    @JoinColumn(name = "ingredient_id",referencedColumnName = "recipeId",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "recipe_id",referencedColumnName = "ingredientId",
                            nullable = false, updatable = false)})
    private final List<Ingredients> ingredients = new ArrayList<>();


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



    @Override
    public String toString() {
        return "Recipes{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeServing=" + recipeServing +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public int hashCode() {
        int result = recipeId.hashCode();
        result = 31 * result + recipeName.hashCode();
        result = 31 * result + recipeServing.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + ingredients.hashCode();
        return result;
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

//    @Override
//    public int hashCode() { return Objects.hash(recipeId, recipeName, recipeServing, description);}
}





