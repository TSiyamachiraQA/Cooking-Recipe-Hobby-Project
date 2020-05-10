package com.qa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Recipes;
import com.qa.dto.IngredientsDTO;
import com.qa.dto.RecipesDTO;

import com.qa.repo.RecipesRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipesControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private RecipesRepo repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Recipes testRecipes;

    private Recipes testRecipesWithID;

    private long recipeId = 1L;

    private RecipesDTO recipesDTO;

    private RecipesDTO mapToDTO(Recipes recipes){return this.mapper.map(recipes, RecipesDTO.class);}


    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.testRecipes = new Recipes("test recipe", 4L, "test description");
        this.testRecipesWithID = this.repository.save(testRecipes);
        this.recipeId = testRecipesWithID.getRecipeId();
        this.recipesDTO = this.mapToDTO(testRecipesWithID);
    }

    @Test
    public void getAllRecipesTest() throws Exception {
        List<RecipesDTO> recipesDTOList = new ArrayList<>();
        recipesDTOList.add(recipesDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllRecipes")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(recipesDTOList));
    }

    @Test
    public void getRecipesByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getRecipesById/" + this.recipeId)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(recipesDTO));
    }

    @Test
    public void createRecipesTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createRecipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(testRecipes))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(recipesDTO));
    }

    @Test
    public void deleteRecipesTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteRecipes/" + this.recipeId)
        ).andExpect(status().isNoContent());
    }



}
