package com.qa.services;

import com.qa.domain.Recipes;
import com.qa.dto.RecipesDTO;
import com.qa.exceptions.RecipesNotFoundException;
import com.qa.repo.RecipesRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RecipesServicesUnitTest {

    @InjectMocks
    private RecipesService service;

    @Mock
    private RecipesRepo repository;

    @Mock
    private ModelMapper mapper;

    private List<Recipes> recipesList;

    private Recipes testRecipes;

    private long recipeId = 1L;

    private Recipes testRecipesWithID;

    private RecipesDTO recipesDTO;

    private RecipesDTO mapToDTO(Recipes recipes){return this.mapper.map(recipes, RecipesDTO.class);}

    @Before
    public void setup(){
        this.recipesList = new ArrayList<>();
        this.testRecipes = new Recipes("Chicken Fried Rice",4L,"This is a famous..");
        this.recipesList.add(testRecipes);
        this.testRecipesWithID = new Recipes(testRecipes.getRecipeName(), testRecipes.getRecipeServing(),testRecipes.getDescriptionSteps());
        this.testRecipesWithID.setRecipeId(recipeId);
        this.recipesDTO = this.mapToDTO(testRecipesWithID);
    }

    @Test
    public void getAllRecipesTest(){
        when(repository.findAll()).thenReturn(this.recipesList);
        when(this.mapper.map(service, RecipesDTO.class)).thenReturn(recipesDTO);
        assertFalse("Service returned no Recipes", this.service.readRecipes().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void createRecipesTest(){
        when(repository.save(testRecipes)).thenReturn(testRecipesWithID);
        when(this.mapper.map(testRecipesWithID, RecipesDTO.class)).thenReturn(recipesDTO);
        assertEquals(this.service.createRecipes(testRecipes), this.recipesDTO);
        verify(repository, times(1)).save(this.testRecipes);
    }

    @Test
    public void findRecipeById(){
        when(this.repository.findById(recipeId)).thenReturn(Optional.ofNullable(testRecipesWithID));
        when(this.mapper.map(testRecipesWithID, RecipesDTO.class)).thenReturn(recipesDTO);
        assertEquals(this.service.findRecipesById(this.recipeId), recipesDTO);
        verify(repository, times(1)).findById(recipeId);
    }

    @Test
    public void deleteRecipesByExistingId(){
        when(this.repository.existsById(recipeId)).thenReturn(true, false);
        assertFalse(service.deleteRecipes(recipeId));
        verify(repository, times(1)).deleteById(recipeId);
        verify(repository, times(2)).existsById(recipeId);
    }

    @Test(expected = RecipesNotFoundException.class)
    public void deleteIngredientsByNonExistingId(){
        when(this.repository.existsById(recipeId)).thenReturn(false);
        service.deleteRecipes(recipeId);
        verify(repository, times(1)).existsById(recipeId);
    }



}
