package com.chato.api.repository;

import com.chato.api.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimestamp(Long senderId, Long receiverId, Long receiverId2, Long senderId2);
}
