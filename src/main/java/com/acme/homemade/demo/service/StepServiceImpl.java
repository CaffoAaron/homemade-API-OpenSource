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
public class StepServiceImpl  {


}
