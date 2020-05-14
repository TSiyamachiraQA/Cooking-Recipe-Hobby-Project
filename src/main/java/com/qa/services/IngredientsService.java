package com.qa.services;

import com.qa.domain.Ingredients;
import com.qa.dto.IngredientsDTO;
import com.qa.exceptions.IngredientsNotFoundException;
import com.qa.repo.IngredientsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientsService {

        private final IngredientsRepo ingredientsRepo;

        private final ModelMapper mapper;

        @Autowired
        public IngredientsService(IngredientsRepo ingredientsRepo, ModelMapper mapper) {
            this.ingredientsRepo = ingredientsRepo;
            this.mapper = mapper;
        }

        private IngredientsDTO mapToDTO(Ingredients ingredient) {
        return this.mapper.map(ingredient, IngredientsDTO.class);
        }

        public List<IngredientsDTO> readIngredients(){
            return this.ingredientsRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
        }

        public IngredientsDTO createIngredients(Ingredients ingredient){
            Ingredients tempIngredients = this.ingredientsRepo.save(ingredient);
            return this.mapToDTO(tempIngredients);
        }

        public IngredientsDTO findIngredientById(Long ingredientId){
            return this.mapToDTO(this.ingredientsRepo.findById(ingredientId).orElseThrow(IngredientsNotFoundException::new));
        }

        public IngredientsDTO updateIngredients(Long ingredientId, Ingredients ingredient){
            Ingredients update = this.ingredientsRepo.findById(ingredientId).orElseThrow(IngredientsNotFoundException::new);
            update.setIngredientName(ingredient.getIngredientName());
            update.setIngredientType(ingredient.getIngredientType());
            Ingredients tempIngredients = this.ingredientsRepo.save(update);
            return this.mapToDTO(tempIngredients);
        }

        public boolean deleteIngredients(Long ingredientId){
            if(!this.ingredientsRepo.existsById(ingredientId)){
                throw new IngredientsNotFoundException();
            }
            this.ingredientsRepo.deleteById(ingredientId);
            return this.ingredientsRepo.existsById(ingredientId);
        }


    }
