package com.movechat.chat.chat.domain;

import com.movechat.chat.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;

@Entity
@Getter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String content;

    private Timestamp chatTime;

    private Integer checkCount;

    @ManyToOne
    @JoinColumn(name = "joinChatId")
    private JoinChat joinChat;

    @ManyToOne
    @JoinColumn(name = "memoId")
    private Memo memo;


}


