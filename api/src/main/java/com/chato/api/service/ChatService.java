package com.chato.api.service;

import com.chato.api.entity.ChatMessage;
import com.chato.api.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        return chatRepository.save(message);
    }

    public List<ChatMessage> getMessagesBetweenUsers(Long userId1, Long userId2) {
        return chatRepository.findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimestamp(userId1, userId2, userId2, userId1);
    }
}