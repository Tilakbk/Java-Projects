package com.tilak.AskMe.GenAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("http://localhost:5173/")
public class GenAiController {

    private final ChatClient chatModel;

    public GenAiController( GoogleGenAiChatModel chatModel)
    {
        this.chatModel= ChatClient.create(chatModel);
    }

    @GetMapping("/{query}")
    public ResponseEntity<String> GenAiResponse(@PathVariable String query)
    {
        String response= chatModel.prompt(query).call().content();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

