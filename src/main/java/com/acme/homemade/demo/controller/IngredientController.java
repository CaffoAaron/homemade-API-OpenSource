package com.acme.homemade.demo.controller;


import com.acme.homemade.demo.domain.model.Ingredient;
import com.acme.homemade.demo.domain.model.Recipe;
import com.acme.homemade.demo.domain.service.IngredientService;
import com.acme.homemade.demo.domain.service.MenuService;
import com.acme.homemade.demo.domain.service.RecipeService;
import com.acme.homemade.demo.resource.IngredientResource;
import com.acme.homemade.demo.resource.RecipeResource;
import com.acme.homemade.demo.resource.SaveIngredientResource;
import com.acme.homemade.demo.resource.SaveRecipeResource;
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
public class IngredientController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IngredientService ingredientService;
}
