package com.acme.homemade.demo.service;

import com.acme.homemade.demo.domain.model.Message;
import com.acme.homemade.demo.domain.reposiroty.*;
import com.acme.homemade.demo.domain.service.MessageService;
import com.acme.homemade.demo.execption.ResourceNotFoundException;
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
    private UserRepository userRepository;


    @Override
    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId).orElseThrow(()->new ResourceNotFoundException("Message","Id",messageId));
    }

    @Override
    public Page<Message> getAllMessageByUserId(Long userId, Pageable pageable) {
        return messageRepository.findByUserId(userId,pageable);
    }

    @Override
    public Page<Message> getAllMessageByChatId(Long chatId, Pageable pageable) {
        return messageRepository.findByUserId(chatId,pageable);
    }

    @Override
    public Message createMessage(Long userId, Message message) {
        return userRepository.findById(userId).map(user -> {
            message.setUser(user);
            return messageRepository.save(message);
        }).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
    }


    @Override
    public ResponseEntity<?> deleteMessage(Long userId, Long messageId) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User","Id", userId);
        return messageRepository.findById(messageId).map(message -> {
            messageRepository.delete(message);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Message","Id",userId));
    }
}
