package com.acme.homemade.demo.domain.service;

import com.acme.homemade.demo.domain.model.Chat;
import com.acme.homemade.demo.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ChatService {

    Chat getChatId(Long chatId);

    Page<Chat> getAllChatByUserId(Long userId, Pageable pageable);

    Chat createChat(Long chatId, Long userId, Chat chat);

    Chat updateChat(Long chatId, Long userId, Chat chat);

    ResponseEntity<?> deleteChat(Long chatId, Long userId, Chat chat);

}
