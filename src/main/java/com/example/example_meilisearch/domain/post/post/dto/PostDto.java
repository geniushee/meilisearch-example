package com.example.example_meilisearch.domain.post.post.dto;

import com.example.example_meilisearch.domain.member.member.entity.Member;
import com.example.example_meilisearch.domain.post.post.entity.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Member writer;
    private String title;
    private String content;

    public PostDto(Post post){
        this.id = post.getId();
        this.createDate = post.getCreateDate();
        this.modifyDate = post.getModifyDate();
        this.writer = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
