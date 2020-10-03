package com.acme.homemade.demo.domain.reposiroty;


import com.acme.homemade.demo.domain.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long>{

    Page<Message> findById (Long Id, Pageable pageable);

    Page<Message> findByUserId (Long userId, Pageable pageable);

    Page<Message> findByChatId (Long chatId, Pageable pageable);

    Optional<Message> findByIdAndChatId (Long Id, Long chatId);

    Optional<Message> finByIdAndUserId (Long Id, Long userId);

}