package com.tilak.AskMe.Ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/ollama")
public class OllamaController {

    private final ChatClient chatModel;

    public OllamaController( OllamaChatModel chatModel)
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
