package com.example.example_meilisearch.domain.post.post.service;

import com.example.example_meilisearch.domain.member.member.entity.Member;
import com.example.example_meilisearch.domain.post.post.dto.PostDto;
import com.example.example_meilisearch.domain.post.post.entity.Post;
import com.example.example_meilisearch.domain.post.post.repository.PostRepository;
import com.example.example_meilisearch.global.event.event.AfterPostCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public Post createPost(Member member, String title, String content){
        Post post = Post.builder()
                .writer(member)
                .title(title)
                .content(content)
                .build();
        post = postRepository.save(post);

        publisher.publishEvent(new AfterPostCreationEvent(this, new PostDto(post)));

        return post;
    }
}
