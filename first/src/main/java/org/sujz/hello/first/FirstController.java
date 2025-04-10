package org.sujz.hello.first;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/first")
public class FirstController {

    private final ChatClient chatClient;

    public FirstController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/hello")
    public String index(String userInput) {
       return this.chatClient.prompt()
            .user(userInput)
            .call()
            .content();
    }
}
