package com.qa.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientsUnitTest {

    private Ingredients ingredients;
    private Ingredients other;

    @Before
    public void setup(){
        ingredients = new Ingredients(1L, "Chicken", "Meat");
        other = new Ingredients(1L, "Chicken", "Meat");
    }

    @Test
    public void settersTest(){
        assertNotNull(ingredients.getIngredientId());
        assertNotNull(ingredients.getIngredientName());
        assertNotNull(ingredients.getIngredientType());

        ingredients.setIngredientId(null);
        assertNull(ingredients.getIngredientId());
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
        assertEquals(1L, ingredients.getIngredientId(), 0);
        assertEquals("Chicken", ingredients.getIngredientName());
        assertEquals("Meat", ingredients.getIngredientType());
    }

    @Test
    public void checkEquality() {
        assertTrue(ingredients.equals(ingredients));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(ingredients.equals(other));
    }

    @Test
    public void ingredientsNameNullButOtherNameNotNull() {
        ingredients.setIngredientName(null);
        assertFalse(ingredients.equals(other));
    }

    @Test
    public void ingredientsNamesNotEqual() {
        other.setIngredientName("Potatoes");
        assertFalse(ingredients.equals(other));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullName() {
        ingredients.setIngredientName(null);
        other.setIngredientName(null);
        assertTrue(ingredients.equals(other));
    }

    @Test
    public void nullIngedientsId() {
        ingredients.setIngredientId(null);
        assertFalse(ingredients.equals(other));
    }

    @Test
    public void nullIngredientsIdOnBoth() {
        ingredients.setIngredientId(null);
        other.setIngredientId(null);
        assertTrue(ingredients.equals(other));
    }

    @Test
    public void otherIngredientsIdDifferent() {
        other.setIngredientId(2L);
        assertFalse(ingredients.equals(other));
    }

    @Test
    public void nullType() {
        ingredients.setIngredientType(null);
        assertFalse(ingredients.equals(other));
    }

    @Test
    public void nullIngredientsTypeOnBoth() {
        ingredients.setIngredientType(null);
        other.setIngredientType(null);
        assertTrue(ingredients.equals(other));
    }

    @Test
    public void otherIngredientsTypeDifferent() {
        other.setIngredientType("Carbs");
        assertFalse(ingredients.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        Ingredients ingredients = new Ingredients("Turkey", "Meat");
        assertNull(ingredients.getIngredientId());
        assertNotNull(ingredients.getIngredientName());
        assertNotNull(ingredients.getIngredientType());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(ingredients.hashCode(), other.hashCode());
    }
    @Test
    public void hashCodeTestWithNull() {
        Ingredients customer = new Ingredients(null, null);
        Ingredients other = new Ingredients(null, null);
        assertEquals(customer.hashCode(), other.hashCode());
    }

}
