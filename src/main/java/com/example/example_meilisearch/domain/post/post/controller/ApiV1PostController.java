package com.example.example_meilisearch.domain.post.post.controller;

//import com.example.example_meilisearch.domain.member.member.entity.Member;
import com.example.example_meilisearch.domain.post.post.entity.Post;
import com.example.example_meilisearch.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class ApiV1PostController {

    private final PostService postService;

    public record PostRequestDto(String title, String content){}
    public record PostResponseDto(Post post){}
}
