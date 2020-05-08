package com.qa.controller;

import com.qa.domain.Ingredients;
import com.qa.dto.IngredientsDTO;
import com.qa.repo.IngredientsRepo;
import com.qa.services.IngredientsService;
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
public class IngredientsControllerUnitTest {

    @InjectMocks
    private IngredientsController controller;

    @Mock
    private IngredientsService service;

    private List<Ingredients> ingredientsList;

    private Ingredients testIngredients;

    private Ingredients testIngredientsWithID;

    private long ingredientId = 1L;

    private IngredientsDTO ingredientsDTO;

    private final ModelMapper mapper = new ModelMapper();

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
        when(service.readIngredients()).thenReturn(this.ingredientsList.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No ingredients found", this.controller.getAllIngredients().getBody().isEmpty());
        verify(service, times(1)).readIngredients();
    }

    @Test
    public void createIngredientsTest(){
        when(this.service.createIngredients(testIngredients)).thenReturn(this.ingredientsDTO);
        assertEquals(this.controller.createIngredients(testIngredients), new ResponseEntity<IngredientsDTO>(this.ingredientsDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createIngredients(testIngredients);
    }

    @Test
    public void deleteIngredientsTestFalse(){
        this.controller.deleteIngredients(ingredientId);
        verify(service, times(1)).deleteIngredients(ingredientId);
    }

    @Test
    public void deleteIngredientsTestTrue(){
        when(service.deleteIngredients(3L)).thenReturn(true);
        this.controller.deleteIngredients(3L);
        verify(service, times(1)).deleteIngredients(3L);
    }

    @Test
    public void getIngredientsByIDTest(){
        when(this.service.findIngredientById(ingredientId)).thenReturn(this.ingredientsDTO);
        assertEquals(this.controller.getIngredientById(ingredientId), new ResponseEntity<IngredientsDTO>(this.ingredientsDTO, HttpStatus.OK));
        verify(service, times(1)).findIngredientById(ingredientId);
    }

}
