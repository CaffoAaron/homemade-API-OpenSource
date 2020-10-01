package com.acme.homemade.demo.domain.reposiroty;

import com.acme.homemade.demo.domain.model.UserNoChef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserNoChefRepository extends JpaRepository<UserNoChef, Long> {
}
