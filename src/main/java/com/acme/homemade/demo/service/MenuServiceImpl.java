package com.acme.homemade.demo.service;

import com.acme.homemade.demo.domain.model.Message;
import com.acme.homemade.demo.domain.reposiroty.MessageRepository;
import com.acme.homemade.demo.domain.reposiroty.RecipeRepository;
import com.acme.homemade.demo.domain.reposiroty.UserChefRepository;
import com.acme.homemade.demo.domain.reposiroty.UserNoChefRepository;
import com.acme.homemade.demo.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserChefRepository chefRepository;

    @Autowired
    private UserNoChefRepository userNoChefRepository;


    @Override
    public Message getMessageById(Long messageId) {
        return null;
    }

    @Override
    public Page<Message> getAllMessageByUserId(Long userId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Message> getAllMessageByChatId(Long chatId, Pageable pageable) {
        return null;
    }

    @Override
    public Message createMessage(Long userId, Message message) {
        return null;
    }

    @Override
    public Message updateMessage(Long userId, Long messageId, Message message) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteMessage(Long userId, Long messageId) {
        return null;
    }
}
