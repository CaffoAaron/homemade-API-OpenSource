package com.acme.homemade.demo.domain.reposiroty;

import com.acme.homemade.demo.domain.model.UserChef;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserChefRepository extends JpaRepository<UserChef, Long> {
}

