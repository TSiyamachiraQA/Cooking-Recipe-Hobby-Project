package com.qa.controller;

import com.qa.domain.Recipes;
import com.qa.dto.RecipesDTO;
import com.qa.services.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipesController {


    private final RecipesService service;

    @Autowired
    public RecipesController(RecipesService service) {
        this.service = service;
    }

    @GetMapping("/getAllRecipes")
    public ResponseEntity<List<RecipesDTO>> getAllRecipes(){
        return ResponseEntity.ok(this.service.readRecipes());
    }

    @PostMapping("/createRecipes")
    public ResponseEntity<RecipesDTO> createRecipes(@RequestBody Recipes recipes){
        return new ResponseEntity<RecipesDTO>(this.service.createRecipes(recipes), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRecipes/{recipeId}")
    public ResponseEntity<?> deleteRecipes(@PathVariable Long recipeId){
        return this.service.deleteRecipes(recipeId)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();

    }

    @GetMapping("/getRecipesById/{recipeId}")
    public ResponseEntity<RecipesDTO> getRecipesById(@PathVariable Long recipeId){
        return ResponseEntity.ok(this.service.findRecipesById(recipeId));
    }

    @PutMapping("/updateRecipes/{recipeId}")
    public ResponseEntity<RecipesDTO> updateRecipes(@PathVariable Long recipeId, @RequestBody Recipes recipes){
        return ResponseEntity.ok(this.service.updateRecipes(recipeId, recipes));
    }

}
