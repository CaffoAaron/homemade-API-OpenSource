package com.acme.homemade.demo.domain.reposiroty;

import com.acme.homemade.demo.domain.model.Step;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.Optional;

 public interface StepRepository extends JpaRepository<Step, Long>{

       Page<Step> findById (Long Id, Pageable pageable);

       Page<Step> findByRecipe_Id (Long recipeId, Pageable pageable);


       Optional<Step> findByIdAndRecipe_Id (Long Id, Long recipe_Id);
}
