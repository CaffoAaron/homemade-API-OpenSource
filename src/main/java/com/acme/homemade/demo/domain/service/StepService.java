package com.acme.homemade.demo.domain.service;

import com.acme.homemade.demo.domain.model.Step;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StepService {
    Step getStepById (Long stepId);

    Page<Step> getAllStep (Pageable pageable);

    Step createStep(Long stepId, Long recipeId ,Step step);

    Step updateStep(Long stepId, Long recipeId, Long stepId, Step step);

    ResponseEntity<?> deleteStep(Long stepId, Long recipeId , Long stepId);

}
