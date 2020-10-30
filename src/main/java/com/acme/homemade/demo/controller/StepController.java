package com.acme.homemade.demo.controller;

import com.acme.homemade.demo.domain.model.Step;
import com.acme.homemade.demo.domain.model.Step;
import com.acme.homemade.demo.domain.service.ChatService;
import com.acme.homemade.demo.domain.service.StepService;
import com.acme.homemade.demo.resource.*;
import com.acme.homemade.demo.resource.StepResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class StepController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StepService stepService;
    @Operation(summary = "Create Step", description = "Create a new Step", tags = {"Steps"})
    @PostMapping("/users/{userId}/Step")
    public StepResource createStep(
            @PathVariable(value = "userId") Long userId,
            @Valid @RequestBody SaveStepResource resource) {
        return convertToResource(stepService.createStep( convertToEntity(resource)));


    }
    private Step convertToEntity(SaveStepResource resource) {
        return mapper.map(resource, Step.class);
    }


    private StepResource convertToResource(Step entity) {
        return mapper.map(entity, StepResource.class);
    }
}
