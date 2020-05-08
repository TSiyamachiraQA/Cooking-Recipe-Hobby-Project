package com.qa.services;

import com.qa.domain.Ingredients;
import com.qa.dto.IngredientsDTO;
import com.qa.exceptions.IngredientsNotFoundException;
import com.qa.repo.IngredientsRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class IngredientsServicesUnitTest {

    @InjectMocks
    private IngredientsService service;

    @Mock
    private IngredientsRepo repository;

    @Mock
    private ModelMapper mapper;

    private List<Ingredients> ingredientsList;

    private Ingredients testIngredients;

    private long ingredientId;

    private Ingredients testIngredientsWithID;

    private IngredientsDTO ingredientsDTO;

    private IngredientsDTO mapToDTO(Ingredients ingredients){return this.mapper.map(ingredients, IngredientsDTO.class);}

    @Before
    public void setup(){
        this.ingredientsList = new ArrayList<>();
        this.testIngredients = new Ingredients("Pasta","Carbs");
        this.ingredientsList.add(testIngredients);
        this.testIngredientsWithID = new Ingredients(testIngredients.getIngredientName(), testIngredients.getIngredientType());
        this.testIngredientsWithID.setIngredientId(ingredientId);
        this.ingredientsDTO = this.mapToDTO(testIngredientsWithID);
    }

    @Test
    public void getAllIngredientsTest(){
        when(repository.findAll()).thenReturn(this.ingredientsList);
        when(this.mapper.map(testIngredientsWithID, IngredientsDTO.class)).thenReturn(ingredientsDTO);
        assertFalse("Service returned no Ingredients", this.service.readIngredients().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void createIngredientsTest(){
        when(repository.save(testIngredients)).thenReturn(testIngredientsWithID);
        when(this.mapper.map(testIngredientsWithID, IngredientsDTO.class)).thenReturn(ingredientsDTO);
        assertEquals(this.service.createIngredients(testIngredients), this.ingredientsDTO);
        verify(repository, times(1)).save(this.testIngredients);
    }

    @Test
    public void findNoteById(){
        when(this.repository.findById(ingredientId)).thenReturn(java.util.Optional.ofNullable(testIngredientsWithID));
        when(this.mapper.map(testIngredientsWithID, IngredientsDTO.class)).thenReturn(ingredientsDTO);
        assertEquals(this.service.findIngredientById(this.ingredientId), ingredientsDTO);
        verify(repository, times(1)).findById(ingredientId);
    }

    @Test
    public void deleteIngredientsByExistingId(){
        when(this.repository.existsById(ingredientId)).thenReturn(true, false);
        assertFalse(service.deleteIngredients(ingredientId));
        verify(repository, times(1)).deleteById(ingredientId);
        verify(repository, times(2)).existsById(ingredientId);
    }

    @Test(expected = IngredientsNotFoundException.class)
    public void deleteIngredientsByNonExistingId(){
        when(this.repository.existsById(ingredientId)).thenReturn(false);
        service.deleteIngredients(ingredientId);
        verify(repository, times(1)).existsById(ingredientId);
    }








}
