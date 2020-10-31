package com.acme.homemade.demo.domain.reposiroty;


import com.acme.homemade.demo.domain.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MenuRepository extends JpaRepository<Menu, Long> {
    Page<Menu> findByUserId(Long userId, Pageable pageable);
}
