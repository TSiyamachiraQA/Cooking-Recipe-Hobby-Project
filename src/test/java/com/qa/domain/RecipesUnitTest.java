package com.qa.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipesUnitTest {

    private Recipes recipes;
    private Recipes other;

    @Before
    public void setUp() {
        recipes = new Recipes(1L, "Chicken Fried Rice", 4L, "This famous dish...");
        other = new Recipes(1L, "Beef Fried Rice", 4L, "This famous dish...");
    }

    @Test
    public void settersTest() {
        assertNotNull(recipes.getRecipeId());
        assertNotNull(recipes.getRecipeName());
        assertNotNull(recipes.getRecipeServing());
        assertNotNull(recipes.getDescription());

        recipes.setRecipeId(null);
        assertNull(recipes.getRecipeId());
        recipes.setRecipeName(null);
        assertNull(recipes.getRecipeName());
        recipes.setRecipeServing(null);
        assertNull(recipes.getRecipeServing());
        recipes.setDescription(null);
        assertNull(recipes.getDescription());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(recipes.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(recipes.equals(new Object()));
    }

    @Test
    public void createRecipeWithId() {
        assertEquals(1L, recipes.getRecipeId(), 0);
        assertEquals("Chicken Fried Rice", recipes.getRecipeName());
        assertEquals(4L, recipes.getRecipeServing(), 0);
        assertEquals("This famous dish...", recipes.getDescription());
    }

    @Test
    public void checkEquality() {
        assertTrue(recipes.equals(recipes));
    }



    @Test
    public void recipeNamesNotEqual() {
        other.setRecipeName("Beef Fried Rice");
        assertFalse(recipes.equals(other));
    }





    @Test
    public void otherIdDifferent() {
        other.setRecipeId(2L);
        assertFalse(recipes.equals(other));
    }

    @Test
    public void nullServing() {
        recipes.setRecipeServing(null);
        assertFalse(recipes.equals(other));
    }


    @Test
    public void constructorWithoutId() {
        Recipes recipes = new Recipes("Chicken Fried Rice",4L,"This famous dish..." );
        assertNull(recipes.getRecipeId());
        assertNotNull(recipes.getRecipeName());
        assertNotNull(recipes.getDescription());
    }


}
