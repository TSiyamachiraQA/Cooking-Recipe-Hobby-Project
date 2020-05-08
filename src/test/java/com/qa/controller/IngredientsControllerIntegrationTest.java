package com.qa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Ingredients;
import com.qa.dto.IngredientsDTO;
import com.qa.repo.IngredientsRepo;
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
public class IngredientsControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private IngredientsRepo repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Ingredients testIngredients;

    private Ingredients testIngredientsWithID;

    private long ingredientId = 1L;

    private IngredientsDTO ingredientsDTO;

    private IngredientsDTO mapToDTO(Ingredients ingredients){return this.mapper.map(ingredients, IngredientsDTO.class);}

    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.testIngredients = new Ingredients("test ingredient", "test type");
        this.testIngredientsWithID = this.repository.save(testIngredients);
        this.ingredientId = testIngredientsWithID.getIngredientId();
        this.ingredientsDTO = this.mapToDTO(testIngredientsWithID);
    }

    @Test
    public void getAllIngredientsTest() throws Exception {
        List<IngredientsDTO> ingredientsDTOList = new ArrayList<>();
        ingredientsDTOList.add(ingredientsDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllIngredients")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(ingredientsDTOList));
    }

    @Test
    public void getIngredientsByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getIngredientsById/" + this.ingredientId)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(ingredientsDTO));
    }

    @Test
    public void createIngredientsTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createIngredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(testIngredients))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(ingredientsDTO));
    }

    @Test
    public void deleteIngredientsTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteIngredients/" + this.ingredientId)
        ).andExpect(status().isNoContent());
    }
}
