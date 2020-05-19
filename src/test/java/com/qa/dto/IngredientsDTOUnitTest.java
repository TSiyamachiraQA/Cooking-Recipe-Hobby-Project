package com.qa.dto;

import com.qa.domain.Ingredients;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientsDTOUnitTest {

    private IngredientsDTO ingredients;
    private IngredientsDTO other;

    @Before
    public void setup(){
        ingredients = new IngredientsDTO("Chicken", "Meat");
        other = new IngredientsDTO( "Milk", "Dairy");
    }

    @Test
    public void settersTest(){
        assertNotNull(ingredients.getIngredientName());
        assertNotNull(ingredients.getIngredientType());

        ingredients.setIngredientName(null);
        assertNull(ingredients.getIngredientName());
        ingredients.setIngredientType(null);
        assertNull(ingredients.getIngredientType());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(ingredients.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(ingredients.equals(new Object()));
    }

    @Test
    public void createIngredientWithId() {
        assertEquals("Chicken", ingredients.getIngredientName());
        assertEquals("Meat", ingredients.getIngredientType());
    }

    @Test
    public void checkEquality() {
        assertTrue(ingredients.equals(ingredients));
    }



    @Test
    public void constructorWithoutId() {
        Ingredients ingredients = new Ingredients("Turkey", "Meat");
        assertNotNull(ingredients.getIngredientName());
        assertNotNull(ingredients.getIngredientType());
    }



}
