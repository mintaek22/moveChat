package com.movechat.chat.chat.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomId;

    private String title;

    @OneToMany(mappedBy = "chatRoom",fetch = FetchType.LAZY)
    private List<JoinChat> joinChats = new ArrayList<>();
}
