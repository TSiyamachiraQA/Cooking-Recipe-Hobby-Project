package com.qa.services;

import com.qa.domain.Ingredients;
import com.qa.dto.IngredientsDTO;
import com.qa.repo.IngredientsRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientsServicesIntegrationTest {

    @Autowired
    private IngredientsService service;

    @Autowired
    private IngredientsRepo repository;

    @Autowired
    private ModelMapper mapper;

    private Ingredients testIngredients;

    private Ingredients testIngredientsWithID;

    private IngredientsDTO mapToDTO(Ingredients ingredients){return this.mapper.map(ingredients, IngredientsDTO.class);}

    @Before
    public void setUp(){
        this.testIngredients = new Ingredients("Minced Beef", "Meat");
        this.repository.deleteAll();
        this.testIngredientsWithID = this.repository.save(this.testIngredients);
    }

    @Test
    public void readIngredientsTest(){
        assertThat(this.service.readIngredients())
                .isEqualTo(
                        Stream.of(this.mapToDTO(testIngredientsWithID)).collect(Collectors.toList())
                );
    }

    @Test
    public void createIngredientsTest(){
        assertEquals(this.mapToDTO(this.testIngredientsWithID), this.service.createIngredients(testIngredients));
    }

    @Test
    public void findIngredientsByIdTest(){
        assertThat(this.service.findIngredientById(this.testIngredientsWithID.getIngredientId())).isEqualTo(this.mapToDTO(this.testIngredientsWithID));
    }

    @Test
    public void deleteIngredientsTest(){
        assertThat(this.service.deleteIngredients(this.testIngredientsWithID.getIngredientId())).isFalse();
    }




}
