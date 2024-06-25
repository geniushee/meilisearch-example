package com.example.example_meilisearch.domain.post.postDocument.entity;

import com.example.example_meilisearch.domain.member.member.entity.Member;
import com.example.example_meilisearch.domain.post.post.dto.PostDto;
import com.example.example_meilisearch.domain.post.post.entity.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDocument {
    private Long id;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    private Member writer;
    private String title;
    private String content;

    public PostDocument(Post post){
        this.id = post.getId();
        this.createdTime = post.getCreateDate();
        this.modifiedTime = post.getModifyDate();
        this.writer = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
    public PostDocument(PostDto post){
        this.id = post.getId();
        this.createdTime = post.getCreateDate();
        this.modifiedTime = post.getModifyDate();
        this.writer = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
