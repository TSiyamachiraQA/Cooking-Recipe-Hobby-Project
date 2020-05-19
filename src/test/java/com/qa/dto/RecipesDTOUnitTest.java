package com.qa.dto;

import com.qa.domain.Ingredients;
import com.qa.domain.Recipes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecipesDTOUnitTest {

    private RecipesDTO recipesDTO;
    private RecipesDTO other;


    @Before
    public void setup(){
        recipesDTO = new RecipesDTO( "Beef Fried Rice", 4L, "This is great...");
        other = new RecipesDTO( "Beef Fried Rice", 4L, "This is great...");
    }

    @Test
    public void settersTest(){
        assertNotNull(recipesDTO.getRecipeName());
        assertNotNull(recipesDTO.getRecipeServing());
        assertNotNull(recipesDTO.getDescription());

        recipesDTO.setRecipeName(null);
        assertNull(recipesDTO.getRecipeName());
        recipesDTO.setRecipeServing(null);
        assertNull(recipesDTO.getRecipeServing());
        recipesDTO.setDescription(null);
        assertNull(recipesDTO.getDescription());

    }

    @Test
    public void equalsWithNull() {
        assertFalse(recipesDTO.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(recipesDTO.equals(new Object()));
    }

    @Test
    public void createRecipeWithId() {
         assertEquals("Beef Fried Rice", recipesDTO.getRecipeName());
        assertEquals(4L, recipesDTO.getRecipeServing(), 0);
        assertEquals("This is great...", recipesDTO.getDescription());
    }

    @Test
    public void checkEquality() {
        assertTrue(recipesDTO.equals(recipesDTO));
    }


    @Test
    public void constructorWithoutId() {
        RecipesDTO recipesDTO = new RecipesDTO( "Egg Fried Rice", 4L, "This is great...");
        assertNotNull(recipesDTO.getRecipeName());
        assertNotNull(recipesDTO.getRecipeServing());
        assertNotNull(recipesDTO.getDescription());
    }




}
