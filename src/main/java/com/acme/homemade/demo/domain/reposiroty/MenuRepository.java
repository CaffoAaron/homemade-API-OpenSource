package com.acme.homemade.demo.domain.reposiroty;


import com.acme.homemade.demo.domain.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Page<Menu> findById(Long Id, Pageable pageable);
    Page<Menu> findByRecipeId(Long recipeId, Pageable pageable);
    Page<Menu> findByUserId(Long userId, Pageable pageable);
    Optional<Menu> findByIdAndRecipeId(Long id, Long recipeId);
}
