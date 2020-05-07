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

        private final IngredientsRepo repo;

        private final ModelMapper mapper;

        @Autowired
        public IngredientsService(IngredientsRepo repo, ModelMapper mapper) {
            this.repo = repo;
            this.mapper = mapper;
        }

        private IngredientsDTO mapToDTO(Ingredients ingredient) {
        return this.mapper.map(ingredient, IngredientsDTO.class);
        }

        public List<IngredientsDTO> readIngredients(){
            return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
        }

        public IngredientsDTO createIngredients(Ingredients ingredient){
            Ingredients tempIngredients = this.repo.save(ingredient);
            return this.mapToDTO(tempIngredients);
        }

        public IngredientsDTO findIngredientById(Long ingredientId){
            return this.mapToDTO(this.repo.findById(ingredientId).orElseThrow(IngredientsNotFoundException::new));
        }

        public IngredientsDTO updateIngredients(Long ingredientId, Ingredients ingredient){
            Ingredients update = this.repo.findById(ingredientId).orElseThrow(IngredientsNotFoundException::new);
            update.setIngredientName(ingredient.getIngredientName());
            update.setIngredientType(ingredient.getIngredientType());
            Ingredients tempIngredients = this.repo.save(ingredient);
            return this.mapToDTO(tempIngredients);
        }

        public boolean deleteIngredients(Long ingredientId){
            if(!this.repo.existsById(ingredientId)){
                throw new IngredientsNotFoundException();
            }
            this.repo.deleteById(ingredientId);
            return this.repo.existsById(ingredientId);
        }


    }
