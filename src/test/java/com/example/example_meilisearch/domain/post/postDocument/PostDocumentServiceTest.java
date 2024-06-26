package com.example.example_meilisearch.domain.post.postDocument;

import com.example.example_meilisearch.domain.post.postDocument.entity.PostDocument;
import com.example.example_meilisearch.domain.post.postDocument.service.PostDocumentService;
import com.meilisearch.sdk.model.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("Test")
@Transactional
public class PostDocumentServiceTest {
    @Autowired
    private PostDocumentService postDocumentService;

    @Test
    @DisplayName("findAllDocument")
    public void test1(){
        Results<PostDocument> posts = postDocumentService.findAll();

        int count = posts.getTotal();
        assertThat(count).isEqualTo(3);

        PostDocument doc1 =(PostDocument) posts.getResults()[0];
        assertThat(doc1.getId()).isEqualTo(1).as("id는 1이다.");
    }

    @Test
    @DisplayName("findAllDocumentOrderByIdDesc")
    public void test2(){
        List<PostDocument> posts = postDocumentService.findAllByOrderByIdDesc();

        assertThat(posts.size()).isEqualTo(3).as("list 크기");


        PostDocument post1 = posts.get(0);
        checkPostDoc(post1, 3L, "title3", "content3");
        PostDocument post2 = posts.get(1);
        checkPostDoc(post2, 2L, "title2", "content2");
        PostDocument post3 = posts.get(2);
        checkPostDoc(post3, 1L, "title1", "content1");

    }

    public void checkPostDoc(PostDocument postDoc, Long id, String title, String content){
        assertThat(postDoc.getId()).isEqualTo(id).as("id 확인");
        assertThat(postDoc.getTitle()).isEqualTo(title).as("title 확인");
        assertThat(postDoc.getContent()).isEqualTo(content).as("content 확인");
    }

    @Test
    @DisplayName("findById")
    public void test3(){
        Optional<PostDocument> opPost = postDocumentService.findById(1L);
        assertThat(opPost.isPresent()).isTrue();

        checkPostDoc(opPost.get(), 1L, "title1", "content1");
    }
}
