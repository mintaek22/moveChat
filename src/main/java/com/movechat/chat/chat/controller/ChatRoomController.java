package com.movechat.chat.chat.controller;

import com.movechat.chat.chat.dto.req.ReqChatRoomInviteUserDto;
import com.movechat.chat.chat.dto.req.ReqCreateChatRoomDto;
import com.movechat.chat.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("/chatRoom")
    public void createChatRoom(@RequestBody ReqCreateChatRoomDto reqCreateChatRoomDto){

    }

    @GetMapping("/chatRooms")
    public void getChatRoomList(){

    }

    @PostMapping("/chatRoom/{chatRoomId}/users")
    public void inviteUser(@PathVariable Long chatRoomId, @RequestBody ReqChatRoomInviteUserDto reqChatRoomInviteUserDto){


    }
}
