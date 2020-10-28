package com.acme.homemade.demo.service;

import com.acme.homemade.demo.domain.model.Chat;
import com.acme.homemade.demo.domain.reposiroty.ChatRepository;
import com.acme.homemade.demo.domain.reposiroty.MessageRepository;
import com.acme.homemade.demo.domain.reposiroty.UserRepository;
import com.acme.homemade.demo.domain.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat getChatId(Long chatId) {
        return null;
    }

    @Override
    public Chat createChat(Long chatId, Long userId, Chat chat) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteChat(Long chatId, Long userId) {
        return null;
    }

    @Override
    public Chat assignChatUser(Long ChatId, Long userId) {
        return null;
    }

    @Override
    public Chat unassignChatUser(Long ChatId, Long userId) {
        return null;
    }
}
