package com.movechat.chat.chat.dto.req;

import com.movechat.chat.chat.domain.JoinChat;
import com.movechat.chat.user.domain.User;
import lombok.Data;
import org.hibernate.mapping.Join;

@Data
public class ReqChatRoomInviteUserDto {

    private Long ChatRoomId;
    private Long UserId;

}
