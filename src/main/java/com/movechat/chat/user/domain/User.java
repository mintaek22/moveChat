package com.movechat.chat.user.domain;

import com.movechat.chat.chat.domain.ChatRoom;
import com.movechat.chat.chat.domain.JoinChat;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String id;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<JoinChat> joinChats = new ArrayList<>();


}

