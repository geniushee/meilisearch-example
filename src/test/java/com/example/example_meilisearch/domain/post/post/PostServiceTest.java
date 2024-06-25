package com.example.example_meilisearch.domain.post.post;

import com.example.example_meilisearch.domain.post.post.entity.Post;
import com.example.example_meilisearch.domain.post.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("Test")
@Transactional
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    @DisplayName("findAll")
    public void test1(){
        List<Post> posts = postService.findAll();
        assertThat(posts.size()).isEqualTo(3);

        Post post1 = posts.get(0);
        assertThat(post1.getId()).isEqualTo(1L);
        assertThat(post1.getTitle()).isEqualTo("title1");
        assertThat(post1.getContent()).isEqualTo("content1");

        Post post2 = posts.get(1);
        assertThat(post2.getId()).isEqualTo(2L);
        assertThat(post2.getTitle()).isEqualTo("title2");
        assertThat(post2.getContent()).isEqualTo("content2");

        Post post3 = posts.get(2);
        assertThat(post3.getId()).isEqualTo(3L);
        assertThat(post3.getTitle()).isEqualTo("title3");
        assertThat(post3.getContent()).isEqualTo("content3");
    }
}
