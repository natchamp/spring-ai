package com.spring.ai.service;

import com.spring.ai.config.ModelConfiguration;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnthropicServiceImpl implements AnthropicService {

    @Autowired
    ModelConfiguration modelConfiguration;

    @Override
    public Object execute() {
        ChatResponse chatResponse = modelConfiguration.getAnthropicChatModel().call(
                new Prompt("Generate the names of 5 famous pirates."));
        return chatResponse;
    }
}
