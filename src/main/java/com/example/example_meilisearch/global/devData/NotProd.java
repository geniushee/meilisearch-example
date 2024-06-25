package com.example.example_meilisearch.global.devData;

import com.example.example_meilisearch.domain.member.member.entity.Member;
import com.example.example_meilisearch.domain.member.member.service.MemberService;
import com.example.example_meilisearch.domain.post.post.service.PostService;
import com.example.example_meilisearch.domain.post.postDocument.service.PostDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;
    private final PostService postService;
    private final MemberService memberService;
    private final PostDocumentService postDocumentService;

    @Bean
    public ApplicationRunner runner(){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                Member member1 = memberService.register("user1", "1234", "user1");
                Member member2 = memberService.register("user2", "1234", "user2");
                Member member3 = memberService.register("user3", "1234", "user3");

                postDocumentService.indexClear();

                postService.createPost(member1, "title1", "content1");
                postService.createPost(member2, "title2", "content2");
                postService.createPost( member3,"title3", "content3");

            }
        };
    }
}
