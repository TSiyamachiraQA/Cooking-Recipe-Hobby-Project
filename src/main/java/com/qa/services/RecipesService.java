package com.qa.services;

import com.qa.domain.Recipes;
import com.qa.dto.RecipesDTO;
import com.qa.exceptions.RecipesNotFoundException;
import com.qa.repo.RecipesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipesService {

    private final RecipesRepo repo;

    private final ModelMapper mapper;

    @Autowired
    public RecipesService(RecipesRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    private RecipesDTO mapToDTO(Recipes recipes){return this.mapper.map(recipes, RecipesDTO.class);}

    public List<RecipesDTO> readRecipes(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public RecipesDTO createRecipes(Recipes recipes){return this.mapToDTO(this.repo.save(recipes));}

    public RecipesDTO findRecipesById(Long recipeId){
        return this.mapToDTO(this.repo.findById(recipeId).orElseThrow(RecipesNotFoundException::new));
    }

    public RecipesDTO updateRecipes(Long recipeId, Recipes recipes){
        Recipes update = this.repo.findById(recipeId).orElseThrow(RecipesNotFoundException::new);
        update.setRecipeName(recipes.getRecipeName());
        update.setRecipeServing(recipes.getRecipeServing());
        update.setRecipeServing(recipes.getRecipeServing());
        update.setDescription(recipes.getDescription());
        Recipes tempRecipes = this.repo.save(update);
        return this.mapToDTO(tempRecipes);
    }

    public boolean deleteRecipes(Long recipeId){
        if(!this.repo.existsById(recipeId)){
            throw new RecipesNotFoundException();
        }
        this.repo.deleteById(recipeId);
        return this.repo.existsById(recipeId);
    }


}
