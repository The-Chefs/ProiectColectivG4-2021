package com.kitchen.iChef.Mapper;

import com.kitchen.iChef.Controller.Model.Request.RecipeIngredientRequest;
import com.kitchen.iChef.Controller.Model.Request.RecipeRequest;
import com.kitchen.iChef.Controller.Model.Response.RecipeIngredientResponse;
import com.kitchen.iChef.Controller.Model.Response.RecipeResponse;
import com.kitchen.iChef.DTO.RecipeDTO;
import com.kitchen.iChef.DTO.RecipeIngredientDTO;
import com.kitchen.iChef.Domain.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapper {
    private final RecipeIngredientMapper recipeIngredientMapper;

    public RecipeMapper(RecipeIngredientMapper recipeIngredientMapper) {
        this.recipeIngredientMapper = recipeIngredientMapper;
    }

    public RecipeDTO mapFromRequest(RecipeRequest recipeRequest) {
        RecipeDTO recipe = new RecipeDTO();

        recipe.setUserId(recipeRequest.getUserId());
        recipe.setDifficulty(recipeRequest.getDifficulty());
        recipe.setImagePath(recipeRequest.getImagePath());
        recipe.setNotes(recipeRequest.getNotes());
        recipe.setPortions(recipeRequest.getPortions());
        recipe.setPreparationTime(recipeRequest.getPreparationTime());
        recipe.setSteps(recipeRequest.getSteps());
        recipe.setUtensils(recipeRequest.getUtensils());
        recipe.setTitle(recipeRequest.getTitle());

        List<RecipeIngredientDTO> list = new ArrayList<>();
        for (RecipeIngredientRequest ri : recipeRequest.getRecipeIngredientsList()) {
            list.add(recipeIngredientMapper.mapFromRequest(ri));
        }
        recipe.setRecipeIngredientDTOSList(list);

        return recipe;
    }

    public RecipeResponse mapToResponse(RecipeDTO recipe) {
        RecipeResponse recipeResponse = new RecipeResponse();

        recipeResponse.setId(recipe.getRecipeId());
        recipeResponse.setPreparationTime(recipe.getPreparationTime());
        recipeResponse.setRating(recipe.getRating());
        recipeResponse.setUserId(recipe.getUserId());
        recipeResponse.setDifficulty(recipe.getDifficulty());
        recipeResponse.setImagePath(recipe.getImagePath());
        recipeResponse.setNotes(recipe.getNotes());
        recipeResponse.setNumberOfViews(recipe.getNumberOfViews());
        recipeResponse.setPortions(recipe.getPortions());
        recipeResponse.setSteps(recipe.getSteps());
        recipeResponse.setUtensils(recipe.getUtensils());
        recipeResponse.setTitle(recipe.getTitle());
        List<RecipeIngredientResponse> list = new ArrayList<>();

        for (RecipeIngredientDTO ri : recipe.getRecipeIngredientDTOSList()) {
            list.add(recipeIngredientMapper.mapToResponse(ri));
        }
        recipeResponse.setRecipeIngredientList(list);
        return recipeResponse;
    }

    public RecipeDTO mapToDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setUserId(recipe.getAppUser().getUserId());
        recipeDTO.setRecipeId(recipe.getRecipeId());
        recipeDTO.setDifficulty(recipe.getDifficulty());
        recipeDTO.setImagePath(recipe.getImagePath());
        recipeDTO.setPreparationTime(recipe.getPreparationTime());
        recipeDTO.setRating(recipe.getRating());
        recipeDTO.setNotes(recipe.getNotes());
        recipeDTO.setNumberOfViews(recipe.getNumberOfViews());
        recipeDTO.setPortions(recipe.getPortions());
        recipeDTO.setSteps(recipe.getSteps());
        recipeDTO.setUtensils(recipe.getUtensils());
        recipeDTO.setTitle(recipe.getTitle());

        return recipeDTO;
    }

    public Recipe mapToEntity(RecipeDTO recipeDto) {
        Recipe recipe = new Recipe();

        recipe.setPortions(recipeDto.getPortions());
        recipe.setSteps(recipeDto.getSteps());
        recipe.setUtensils(recipeDto.getUtensils());
        recipe.setTitle(recipeDto.getTitle());
        recipe.setRecipeId(recipeDto.getRecipeId());
        recipe.setDifficulty(recipeDto.getDifficulty());
        recipe.setRating(recipeDto.getRating());
        recipe.setNotes(recipeDto.getNotes());
        recipe.setNumberOfViews(recipeDto.getNumberOfViews());
        recipe.setImagePath(recipeDto.getImagePath());
        recipe.setPreparationTime(recipeDto.getPreparationTime());

        return recipe;
    }
}