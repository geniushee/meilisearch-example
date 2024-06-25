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
}
