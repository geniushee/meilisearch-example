package com.example.example_meilisearch.domain.post.postDocument.eventListener;

import com.example.example_meilisearch.domain.post.postDocument.service.PostDocumentService;
import com.example.example_meilisearch.global.event.event.AfterPostCreationEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostEventListener {
    private final PostDocumentService postDocumentService;

    @EventListener
    @Async
    public void listen(AfterPostCreationEvent event) throws JsonProcessingException {
        postDocumentService.addPostDocument(event.getPostDto());
    }
}
