package com.qa.services;

import com.qa.domain.Recipes;
import com.qa.dto.RecipesDTO;
import com.qa.repo.RecipesRepo;
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
public class RecipesServicesIntegrationTes {

    @Autowired
    private RecipesService service;

    @Autowired
    private RecipesRepo repository;

    @Autowired
    private ModelMapper mapper;

    private Recipes testRecipes;

    private Recipes testRecipesWithID;

    private RecipesDTO mapToDTO(Recipes recipes){return this.mapper.map(recipes, RecipesDTO.class);}


    @Before
    public void setUp(){
        this.testRecipes = new Recipes("Chicken Fried Rice",4L,"This is a famous..");
        this.repository.deleteAll();
        this.testRecipesWithID = this.repository.save(this.testRecipes);
    }

    @Test
    public void readRecipesTest(){
        assertThat(this.service.readRecipes())
                .isEqualTo(
                        Stream.of(this.mapToDTO(testRecipesWithID)).collect(Collectors.toList())
                );
    }

    @Test
    public void createRecipesTest(){
        assertEquals(this.mapToDTO(this.testRecipesWithID), this.service.createRecipes(testRecipes));
    }

    @Test
    public void findRecipesByIdTest(){
        assertThat(this.service.findRecipesById(this.testRecipesWithID.getRecipeId())).isEqualTo(this.mapToDTO(this.testRecipesWithID));
    }

    @Test
    public void deleteRecipesTest(){
        assertThat(this.service.deleteRecipes(this.testRecipesWithID.getRecipeId())).isFalse();
    }



}
