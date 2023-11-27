package com.movechat.chat.chat.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Builder
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomId;

    private String title;

    @OneToMany(mappedBy = "chatRoom",fetch = FetchType.LAZY)
    private List<JoinChat> joinChats = new ArrayList<>();

    public void addUser(List<JoinChat> joinChats) {
        this.joinChats = joinChats;
    }
}
