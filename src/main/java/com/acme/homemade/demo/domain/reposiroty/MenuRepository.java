package com.acme.homemade.demo.domain.reposiroty;


import com.acme.homemade.demo.domain.model.Ingredient;
import com.acme.homemade.demo.domain.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long>{

    Page<Menu> findById (Long Id, Pageable pageable);

    Page<Menu> findByRecipesId (Long recipesId, Pageable pageable);

    Optional<Menu> findByIdAndRecipesId (Long Id, Long recipesId);

    Optional<Menu> finByIdAndUserId (Long Id, Long userId);

}
