package com.movechat.chat.chat.domain;

import com.movechat.chat.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class JoinChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joinChatId;

    @OneToMany(mappedBy = "joinChat",fetch = FetchType.LAZY)
    private List<Message> messages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chatRoomId")
    private ChatRoom chatRoom;

}
