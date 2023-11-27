package com.movechat.chat.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movechat.chat.chat.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class WebSocketChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final Set<WebSocketSession> sessions = new HashSet<>();
    private final Map<Long,Set<WebSocketSession>> chatRoomSessionMap = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonProcessingException {

        String payload = message.getPayload();

        MessageDto messageDto = objectMapper.readValue(payload, MessageDto.class);

        Long chatRoomId = messageDto.getChatRoomId();

        if(!chatRoomSessionMap.containsKey(chatRoomId)){
            chatRoomSessionMap.put(chatRoomId,new HashSet<>());
        }

        Set<WebSocketSession> chatRoomSession = chatRoomSessionMap.get(chatRoomId);

        if(messageDto.getMessageType().equals(MessageDto.MessageType.ENTER)){
            chatRoomSession.add(session);
        }

        if(chatRoomSession.size()>=3){
            removeClosedSession(chatRoomSession);
        }
        sendMessageToChatRoom(messageDto, chatRoomSession);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        sessions.remove(session);
    }

    private void removeClosedSession(Set<WebSocketSession> chatRoomSession){
        chatRoomSession.removeIf(sess -> !sessions.contains(sess));
    }

    private void sendMessageToChatRoom(MessageDto messageDto,Set<WebSocketSession> chatRoomSession){
        chatRoomSession.parallelStream().forEach(sess -> {
            try {
                sendMessage(sess, messageDto);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public <T> void sendMessage(WebSocketSession session, T message) throws IOException {

        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));

    }

}
