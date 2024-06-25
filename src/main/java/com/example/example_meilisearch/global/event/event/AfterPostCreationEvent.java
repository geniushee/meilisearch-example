package com.example.example_meilisearch.global.event.event;

import com.example.example_meilisearch.domain.post.post.dto.PostDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class AfterPostCreationEvent extends ApplicationEvent {

    @Getter
    private final PostDto postDto;


    public AfterPostCreationEvent(Object source, PostDto postDto) {
        super(source);
        this.postDto = postDto;
    }
}
