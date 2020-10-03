package com.acme.homemade.demo.domain.reposiroty;

import com.acme.homemade.demo.domain.model.Chat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long>{

    Page<Chat> findById (Long Id, Pageable pageable);

    Page<Chat> findByUsersId (Long UsersId, Pageable pageable);

    Optional<Chat> findByIdAndUsersId (Long Id, Long usersId);


}
