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

    @Override
    public String toString(){
        return "IngredientsDTO [ingredientsId=" + ingredientId + ", ingredientName=" + ingredientName + ", ingredientType" + ingredientType + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientsDTO that = (IngredientsDTO) o;

        if (!ingredientId.equals(that.ingredientId)) return false;
        if (!ingredientName.equals(that.ingredientName)) return false;
        return ingredientType.equals(that.ingredientType);
    }

    @Override
    public int hashCode() {
        int result = ingredientId.hashCode();
        result = 31 * result + ingredientName.hashCode();
        result = 31 * result + ingredientType.hashCode();
        return result;
    }
}

