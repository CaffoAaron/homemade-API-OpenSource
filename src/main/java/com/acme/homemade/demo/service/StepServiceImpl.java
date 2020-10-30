package com.acme.homemade.demo.service;

import com.acme.homemade.demo.domain.model.Step;
import com.acme.homemade.demo.domain.model.UserChef;
import com.acme.homemade.demo.domain.reposiroty.StepRepository;
import com.acme.homemade.demo.domain.reposiroty.UserChefRepository;
import com.acme.homemade.demo.domain.service.StepService;
import com.acme.homemade.demo.execption.ResourceNotFoundException;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StepServiceImpl  {

    @Autowired
    private StepRepository stepRepository;

    @Autowired
    ///private UserNoChefRepository userNoChefRepository;

    @Override
    public Step getStepById(Long stepId) {
        return stepRepository.findById(stepId).orElseThrow(() -> new ResourceNotFoundException("Step", "Id", stepId));
    }

    @Override
    public Page<Step> getAllStepByUserId(Long userId, Pageable pageable) {
        return stepRepository.findByUserId(Long userId);
    }

    @Override
    public Page<Step> getAllStep(Pageable pageable) {
        return stepRepository.findAll(pageable);
    }

    @Override
    public Step getStepByIdAndUserId(Long userId, Long stepId) {
        return stepRepository.findByIdAndUserChefId(stepId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Comment not found with Id " + StepId +
                                " and StepId " + StepId));
    }

    @Override
    public Step createStep(Long userId, Step step) {
        return userChefRepository.findById(userId).map( userNoChef -> {
            Step.setUser(userNoChef);
            return stepRepository.save(step);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "UserId", "Id", userId));
    }

    @Override
    public Step updateStep(Long userId, Long stepId, Step step) {
        if (!userChefRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return stepRepository.findById(stepId).map(step1 -> {
            step1.setText(step.getText());
            step1.setText(step.getImage());
            return stepRepository.save(step1);
        }).orElseThrow(() -> new ResourceNotFoundException("Step", "Id", stepId));
    }

    @Override
    public ResponseEntity<?> deleteStep(Long userId, Long stepId) {
        if (!userChefRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return stepRepository.findById(StepId).map(step -> {
            stepRepository.delete(step);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Step", "Id", StepId));
    }




}
