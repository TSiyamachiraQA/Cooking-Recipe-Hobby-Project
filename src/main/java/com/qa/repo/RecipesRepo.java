package com.qa.repo;


import com.qa.domain.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepo extends JpaRepository<Recipes, Long> {
}
