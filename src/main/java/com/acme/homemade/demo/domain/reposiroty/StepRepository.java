package com.acme.homemade.demo.domain.reposiroty;

import com.acme.homemade.demo.domain.model.Step;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.Optional;

 public interface StepRepository extends JpaRepository<Step, Long>{

     Page<Step> findByRecipeId(Long recipeId, Pageable pageable);
     Optional<Step> findByIdAndRecipeId(Long Id, Long recipeId);
}
