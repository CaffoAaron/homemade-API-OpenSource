package com.acme.homemade.demo;

import com.acme.homemade.demo.domain.model.Recipe;
import com.acme.homemade.demo.domain.reposiroty.RecipeRepository;
import com.acme.homemade.demo.domain.reposiroty.UserChefRepository;
import com.acme.homemade.demo.domain.service.RecipeService;
import com.acme.homemade.demo.execption.ResourceNotFoundException;
import com.acme.homemade.demo.service.RecipeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

public class RecipeServiceImpIntegrationTest {

    @MockBean
    private RecipeRepository recipeRepository;

    @MockBean
    private UserChefRepository userChefRepository;

    @Autowired
    private RecipeService recipeService;

    @TestConfiguration
    static class PostServiceImplTestConfiguration {
        @Bean
        public RecipeService recipeService() {
            return new RecipeServiceImpl();
        }
    }

    @Test
    @DisplayName("When GetRecipeByTitle With Valid Title Then Returns Recipe")
    public void WhenGetRecipeByTitleWithValidTitleThenReturnsRecipe() {
        // Arrange
        String title = "Rocoto relleno";
        String description = "El mejor rocoto relleno de todo chincha";
        String content = "the best roto relleno";
        Recipe recipe = new Recipe();
        recipe.setId(10L);
        recipe.setTitle(title);
        recipe.setDescription(description);
        recipe.setContent(content);
        //given(postRepository.findByTitle(post.getTitle()))
        //        .willReturn(Optional.of(post));
        when(recipeRepository.findByTitle(title))
                .thenReturn(Optional.of(recipe));

        // Act
        Recipe foundRecipe = recipeService.getRecipeByTitle(title);

        // Assert
        assertThat(foundRecipe.getTitle()).isEqualTo(title);
    }
    @Test
    @DisplayName("When GetRecipeByTitle With Invalid Title Then Returns ResourceNotFoundException")
    public void WhenGetRecipeByTitleWithInvalidTitleThenReturnsResourceNotFoundException() {
        // Arrange
        String title = "Rocoto relleno";
        String template = "Resource %s not found for %s with value %s";
        when(recipeRepository.findByTitle(title))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Recipe", "Title", title);

        // Act
        Throwable exception = catchThrowable(() -> {
            Recipe foundPost = recipeService.getRecipeByTitle(title);
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }
}
