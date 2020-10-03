package com.acme.homemade.demo.service;

import com.acme.homemade.demo.domain.model.Step;
import com.acme.homemade.demo.domain.model.Recipe;
import com.acme.homemade.demo.domain.reposiroty.StepRepository;
import com.acme.homemade.demo.domain.reposiroty.RecipeRepository;
import com.acme.homemade.demo.domain.service.StepService;
import com.acme.homemade.demo.execption.ResourceNotFoundException;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StepServiceImpl implements StepServicw{
    @Autowired
    private StepRepository stepRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Step getStepById(Long stepId) {
        return stepRepository.findById(stepId).orElseThrow(() -> new ResourceNotFoundException("Step", "Id", stepId));
    }

    @Override
    public Page<Step> getAllStepByRecipeId(Long recipeId, Pageable pageable) {
        return stepRepository.findByRecipeId(recipeId, pageable);
    }

    @Override
    public Page<Step> getAllStep(Pageable pageable) {
        return stepRepository.findAll(pageable);
    }

    @Override
    public Step getStepByIdAndRecipeId(Long recipeId, Long stepId) {
        return stepRepository.findByIdAndUserId(stepId, recipeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Step not found with Id " + stepId +
                                " and RecipeId " + recipeId));
    }

    @Override
    public Step createStep(Long recipeId, Step step) {
        return RecipeRepository.findById(recipeId).map( Recipe -> {
            step.setRecipe(recipe);
            return stepRepository.save(step);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "RecipeId", "Id", recipeId));
    }

    @Override
    public Step updateStep(Long recipeId, Long stepId, Step step) {
        if (!recipeRepository.existsById(recipeId))
            throw new ResourceNotFoundException("Recipe", "Id", recipeId);
        return stepRepository.findById(stepId).map(step1 -> {
            step1.setDate(publication.getText());
            step1.setImage(publication.getImage());
            return stepRepository.save(step1);
        }).orElseThrow(() -> new ResourceNotFoundException("Step", "Id", stepId));
    }

    @Override
    public ResponseEntity<?> deleteStep(Long recipeId, Long stepId) {
        if (!RecipeRepository.existsById(recipeId))
            throw new ResourceNotFoundException("Recipe", "Id", recipeId);
        return stepRepository.findById(stepId).map(step -> {
            stepRepository.delete(step);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Step", "Id", stepId));
    }
}
