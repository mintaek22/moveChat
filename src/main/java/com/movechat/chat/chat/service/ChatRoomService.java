package com.movechat.chat.chat.service;

import com.movechat.chat.chat.domain.ChatRoom;
import com.movechat.chat.chat.domain.JoinChat;
import com.movechat.chat.chat.dto.req.ReqChatRoomInviteUserDto;
import com.movechat.chat.chat.dto.req.ReqCreateChatRoomDto;
import com.movechat.chat.chat.repository.ChatRoomRepository;
import com.movechat.chat.chat.repository.JoinChatRepository;
import com.movechat.chat.exception.EntityNotfoundException;
import com.movechat.chat.user.domain.User;
import com.movechat.chat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final JoinChatRepository joinChatRepository;
    private final UserRepository userRepository;


    public void createChatRoom(ReqCreateChatRoomDto reqCreateChatRoomDto){

        ChatRoom chatRoom = reqCreateChatRoomDto.toEntity();

    }

    public void chatRoomAddUser(ReqChatRoomInviteUserDto reqChatRoomInviteUserDto){
        User user = userRepository.findById(reqChatRoomInviteUserDto.getUserId()).orElseThrow();
        ChatRoom chatRoom = chatRoomRepository.findById(reqChatRoomInviteUserDto.getChatRoomId()).orElseThrow();

        JoinChat joinChat = JoinChat.builder().user(user).chatRoom(chatRoom).build();
    }
}
