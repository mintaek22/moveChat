package com.movechat.chat.chat.dto.req;

import com.movechat.chat.chat.domain.ChatRoom;
import lombok.Builder;
import lombok.Data;

@Data
public class ReqCreateChatRoomDto {

    private Long userId;
    private String title;

    public ChatRoom toEntity(){
        return ChatRoom.builder().
                title(title).
                build();

    }

}
