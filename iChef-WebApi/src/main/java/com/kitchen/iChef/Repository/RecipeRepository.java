package com.kitchen.iChef.Repository;

import com.kitchen.iChef.Domain.Recipe;
import com.kitchen.iChef.Repository.Interfaces.ICrudRepository;
import com.kitchen.iChef.Repository.Interfaces.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository implements ICrudRepository<Recipe, String> {
    private final IRecipeRepository iRecipeRepository;

    @Autowired
    public RecipeRepository(IRecipeRepository iRecipeRepository) {
        this.iRecipeRepository = iRecipeRepository;
    }

    @Override
    public Recipe findOne(String s) {
        if (iRecipeRepository.findById(s).isPresent()) {
            return iRecipeRepository.findById(s).get();
        }
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        List<Recipe> allRecipes = new ArrayList<>();
        Iterable<Recipe> recipes = iRecipeRepository.findAll();
        for (Recipe recipe : recipes) {
            allRecipes.add(recipe);
        }
        return allRecipes;
    }

    @Override
    public Recipe save(Recipe entity) {
        return iRecipeRepository.save(entity);
    }

    @Override
    public Recipe delete(String s) {
        Recipe recipe = findOne(s);
        iRecipeRepository.deleteById(s);
        return recipe;
    }

    @Override
    public Recipe update(Recipe entity) {
        iRecipeRepository.deleteById(entity.getRecipeId());
        iRecipeRepository.save(entity);
        return entity;
    }
}