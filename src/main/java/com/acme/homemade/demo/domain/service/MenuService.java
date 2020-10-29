package com.acme.homemade.demo.domain.service;

import com.acme.homemade.demo.domain.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MenuService {
    Menu getMenuById(Long menuId);
    Page<Menu> getAllMenuByRecipeId (Long recipeId, Pageable pageable);
    Page<Menu> getAllMenu (Pageable pageable);
    Page<Menu> getAllMenuByUserId(Long recipeId, Pageable pageable);
    Menu assignMenuRecipe(Long menuId, Long recipeId);
    Menu unassignMenuUser(Long menuId, Long userId);
    Menu createMenu(Long recipeId, Long userId, Menu menu);
    Menu updateMenu(Long userId, Long menuId, Menu menu);
    ResponseEntity<?> deleteMenu(Long menuId);
}
