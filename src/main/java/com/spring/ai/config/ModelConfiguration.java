package com.spring.ai.config;

import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import com.google.cloud.vertexai.VertexAI;
import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.anthropic.AnthropicChatOptions;
import org.springframework.ai.anthropic.api.AnthropicApi;
import org.springframework.ai.azure.openai.AzureOpenAiChatModel;
import org.springframework.ai.azure.openai.AzureOpenAiChatOptions;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.ai.mistralai.MistralAiChatOptions;
import org.springframework.ai.mistralai.api.MistralAiApi;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiApi;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration {

    @Bean
    public AnthropicChatModel getAnthropicChatModel() {
        return new AnthropicChatModel(new AnthropicApi("API Key"), AnthropicChatOptions.builder()
                .model("claude-3-7-sonnet-latest")
                .temperature(0.4)
                .build());
    }

    @Bean
    public AzureOpenAiChatModel getAureOPenAIChatModel() {
        return new AzureOpenAiChatModel(new OpenAIClientBuilder()
                .credential(new AzureKeyCredential("API Key"))
                .endpoint("ENd Point"), AzureOpenAiChatOptions.builder()
                .deploymentName("")
                .temperature(0.4)
                .build());
    }

    @Bean
    public MistralAiChatModel getMistralAiChatModel() {
        return new MistralAiChatModel(new MistralAiApi("API Key"), MistralAiChatOptions.builder()
                .model("Model")
                .temperature(0.4)
                .maxTokens(200)
                .build());
    }

    @Bean
    public OllamaChatModel getOllamaChatModel() {
        OllamaOptions ollamaOptions = new OllamaOptions();
        ollamaOptions.setModel("model");
        ollamaOptions.setTemperature(0.9);
        return OllamaChatModel.builder().ollamaApi(new OllamaApi("url")).defaultOptions(ollamaOptions).build();
    }

    @Bean
    public OpenAiChatModel getOpenAiCHatModel() {
        return new OpenAiChatModel(new OpenAiApi("api key"), OpenAiChatOptions.builder()
                .model("gpt-3.5-turbo")
                .temperature(0.4)
                .maxTokens(200)
                .build());
    }

    @Bean
    public StabilityAiImageModel getStabilityAiImageModel(){
        return new StabilityAiImageModel(new StabilityAiApi(""),
                StabilityAiImageOptions.builder()
                        .model("model")
                        .height(1024)
                        .width(1024)
                        .build());
    }

    @Bean
    public VertexAiGeminiChatModel getVertexAiGeminiChatModel(){
        return new VertexAiGeminiChatModel(new VertexAI(),
                VertexAiGeminiChatOptions.builder()
                        .model("model")
                        .temperature(0.7)
                        .build());
    }
}