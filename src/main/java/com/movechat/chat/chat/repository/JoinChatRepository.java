package com.movechat.chat.chat.repository;

import com.movechat.chat.chat.domain.JoinChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinChatRepository extends JpaRepository<JoinChat,Long> {
}
