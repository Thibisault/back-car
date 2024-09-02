package com.chato.api.controller;

import com.chato.api.entity.ChatMessage;
import com.chato.api.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {
        return chatService.saveMessage(message);
    }

    @GetMapping("/{userId1}/{userId2}")
    public List<ChatMessage> getMessagesBetweenUsers(@PathVariable Long userId1, @PathVariable Long userId2) {
        return chatService.getMessagesBetweenUsers(userId1, userId2);
    }

}
