package com.tilak.AskMe.Groq;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("http://localhost:5173/")
public class GroqController {

    private final OpenAiChatModel chatModel;

    public GroqController( OpenAiChatModel chatModel)
    {
        this.chatModel=chatModel;
    }

    @GetMapping("/{query}")
    public ResponseEntity<String> groqResponse(@PathVariable String query)
    {
        String response= chatModel.call(query);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
