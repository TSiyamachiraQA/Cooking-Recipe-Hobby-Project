package com.qa.dto;

public class IngredientsDTO {

    private Long ingredientId;
    private String ingredientName;
    private String ingredientType;

    public IngredientsDTO(){}

    public IngredientsDTO(String ingredientName, String ingredientType) {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }
}
