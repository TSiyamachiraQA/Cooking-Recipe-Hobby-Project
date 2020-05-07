package com.qa.controller;

import com.qa.domain.Ingredients;
import com.qa.dto.IngredientsDTO;
import com.qa.services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientsController {

    private final IngredientsService service;

    @Autowired
    public IngredientsController(IngredientsService service) {
        this.service = service;
    }

    @GetMapping("/getAllIngredients")
    public ResponseEntity<List<IngredientsDTO>> getAllIngredients(){
        return ResponseEntity.ok(this.service.readIngredients());
    }

    @PostMapping("/createIngredients")
    public ResponseEntity<IngredientsDTO> createIngredients(@RequestBody Ingredients ingredient){
        return new ResponseEntity<IngredientsDTO>(this.service.createIngredients(ingredient), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteIngredients/{ingredientId}")
    public ResponseEntity<?> deleteIngredients(@PathVariable Long ingredientId){
        return this.service.deleteIngredients(ingredientId)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();

    }

    @GetMapping("/getIngredientsById/{ingredientId}")
    public ResponseEntity<IngredientsDTO> getIngredientById(@PathVariable Long ingredientId){
        return ResponseEntity.ok(this.service.findIngredientById(ingredientId));
    }

    @PutMapping("/updateIngredients/{ingredientId}")
    public ResponseEntity<IngredientsDTO> updateIngredients(@PathVariable Long ingredientId, @RequestBody Ingredients ingredient){
        return ResponseEntity.ok(this.service.updateIngredients(ingredientId, ingredient));
    }


}
