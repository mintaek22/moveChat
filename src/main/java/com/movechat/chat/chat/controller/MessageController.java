package com.movechat.chat.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chatRoom")
public class MessageController {

    @PostMapping("/{chatRoomId}/message")
    public void postMessage(@PathVariable Long chatRoomId){

    }

    @GetMapping("/{chatRoomId}/messages")
    public void getMessages(@PathVariable Long chatRoomId){

    }
}
