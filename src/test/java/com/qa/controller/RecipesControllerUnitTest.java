package com.qa.controller;

import com.qa.domain.Ingredients;
import com.qa.domain.Recipes;
import com.qa.dto.IngredientsDTO;
import com.qa.dto.RecipesDTO;
import com.qa.services.IngredientsService;
import com.qa.services.RecipesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RecipesControllerUnitTest {

    @InjectMocks
    private RecipesController controller;

    @Mock
    private RecipesService service;

    private List<Recipes> recipesList;

    private Recipes testRecipes;

    private Recipes testRecipesWithID;

    private long recipeId = 1L;

    private RecipesDTO recipesDTO;

    private final ModelMapper mapper = new ModelMapper();

    private RecipesDTO mapToDTO(Recipes recipes){return this.mapper.map(recipes, RecipesDTO.class);}

    @Before
    public void setup(){
        this.recipesList = new ArrayList<>();
        this.testRecipes = new Recipes("Chicken Fried Rice",4L,"This is a famous..");
        this.recipesList.add(testRecipes);
        this.testRecipesWithID = new Recipes(testRecipes.getRecipeName(), testRecipes.getRecipeServing(),testRecipes.getDescription());
        this.testRecipesWithID.setRecipeId(recipeId);
        this.recipesDTO = this.mapToDTO(testRecipesWithID);
    }

    @Test
    public void getAllRecipesTest(){
        when(service.readRecipes()).thenReturn(this.recipesList.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No recipe found", this.controller.getAllRecipes().getBody().isEmpty());
        verify(service, times(1)).readRecipes();
    }

    @Test
    public void createRecipesTest(){
        when(this.service.createRecipes(testRecipes)).thenReturn(this.recipesDTO);
        assertEquals(this.controller.createRecipes(testRecipes), new ResponseEntity<RecipesDTO>(this.recipesDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createRecipes(testRecipes);
    }

    @Test
    public void deleteIngredientsTestFalse(){
        this.controller.deleteRecipes(recipeId);
        verify(service, times(1)).deleteRecipes(recipeId);
    }

    @Test
    public void deleteIngredientsTestTrue(){
        when(service.deleteRecipes(3L)).thenReturn(true);
        this.controller.deleteRecipes(3L);
        verify(service, times(1)).deleteRecipes(3L);
    }

    @Test
    public void getIngredientsByIDTest(){
        when(this.service.findRecipesById(recipeId)).thenReturn(this.recipesDTO);
        assertEquals(this.controller.getRecipesById(recipeId), new ResponseEntity<RecipesDTO>(this.recipesDTO, HttpStatus.OK));
        verify(service, times(1)).findRecipesById(recipeId);
    }

}
