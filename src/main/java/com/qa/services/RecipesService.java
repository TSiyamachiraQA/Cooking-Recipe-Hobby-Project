package com.qa.services;

import com.qa.domain.Ingredients;
import com.qa.domain.Recipes;
import com.qa.dto.RecipesDTO;
import com.qa.exceptions.RecipesNotFoundException;
import com.qa.repo.IngredientsRepo;
import com.qa.repo.RecipesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipesService {

    private final RecipesRepo recipesRepo;

    private final IngredientsRepo ingredientsRepo;

    private final ModelMapper mapper;

    @Autowired
    public RecipesService(RecipesRepo recipesRepo,IngredientsRepo ingredientsRepo, ModelMapper mapper) {
        this.recipesRepo = recipesRepo;
        this.ingredientsRepo = ingredientsRepo;
        this.mapper = mapper;
    }
    private RecipesDTO mapToDTO(Recipes recipes){return this.mapper.map(recipes, RecipesDTO.class);}

    public List<RecipesDTO> readRecipes(){
        return this.recipesRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public RecipesDTO createRecipes(Recipes recipes){return this.mapToDTO(this.recipesRepo.save(recipes));}

    public RecipesDTO findRecipesById(Long recipeId){
        return this.mapToDTO(this.recipesRepo.findById(recipeId).orElseThrow(RecipesNotFoundException::new));
    }

    public RecipesDTO updateRecipes(Long recipeId, Recipes recipes){
        Recipes update = this.recipesRepo.findById(recipeId).orElseThrow(RecipesNotFoundException::new);
        update.setRecipeName(recipes.getRecipeName());
        update.setRecipeServing(recipes.getRecipeServing());
        update.setRecipeServing(recipes.getRecipeServing());
        update.setDescriptionSteps(recipes.getDescriptionSteps());
        Recipes tempRecipes = this.recipesRepo.save(update);
        return this.mapToDTO(tempRecipes);
    }

    public boolean deleteRecipes(Long recipeId){
        if(!this.recipesRepo.existsById(recipeId)){
            throw new RecipesNotFoundException();
        }
        this.recipesRepo.deleteById(recipeId);
        return this.recipesRepo.existsById(recipeId);
    }

    public RecipesDTO addIngredientsToRecipes( Long recipeId, Long ingredientsId){
        Recipes recipes = this.recipesRepo.findById(recipeId).orElseThrow(RecipesNotFoundException::new);
        Ingredients ingredients = this.ingredientsRepo.findById(ingredientsId).orElseThrow(RecipesNotFoundException::new);
        recipes.getIngredients().add(ingredients);
        return this.mapToDTO(this.recipesRepo.saveAndFlush(recipes));
    }


}
