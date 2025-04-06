package com.spring.ai.controller;

import com.spring.ai.service.AnthropicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring/ai")
@Slf4j
public class AnthropicController {
    @Autowired
    private AnthropicService anthropicService;

    @PostMapping("/anthropic")
    public ResponseEntity<Object> anthropic(){
        //log.info("Inside AnthropicController::anthropic()");
        Object object = anthropicService.execute();
        //log.info("Exit from AnthropicController::anthropic()");
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
