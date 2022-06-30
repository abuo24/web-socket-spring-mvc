package com.techprimers.springbootwebsocketexample.resource;

import com.techprimers.springbootwebsocketexample.model.User;
import com.techprimers.springbootwebsocketexample.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;

//    @MessageMapping("/user")
//    @SendTo("/topic/user")
//    public UserResponse getUser(User user) {
//        return new UserResponse("Hi " + user.getName());
//    }

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void send(SimpMessageHeaderAccessor sha, @Payload String username) {
        String message = "Hello from " + sha.getUser().getName();
        System.out.println(message);
        System.out.println(username);
        simpMessagingTemplate.convertAndSendToUser(username, "/queue/messages", message);
    }

}
