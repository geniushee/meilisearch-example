package com.example.example_meilisearch.domain.post.postDocument.repository;

import com.example.example_meilisearch.domain.post.post.dto.PostDto;
import com.example.example_meilisearch.domain.post.postDocument.entity.PostDocument;
import com.example.example_meilisearch.global.meiliSearch.MeiliConfig;
import com.example.example_meilisearch.global.ut.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meilisearch.sdk.Index;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostDocumentRepository {
    // docker 볼륨에 저장되는 형태이기때문에 레포지터리 형태로 구현하여 docs를 저장
    private final MeiliConfig meiliConfig;
    private Index postIndex;

    public Index getIndex(){
        if(postIndex == null) postIndex = meiliConfig.meiliSearchClient().index("post");
        return postIndex;
    }

    public void addPostDocument(PostDto postDto) throws JsonProcessingException {
        Index index = getIndex();
        String doc = Util.Json.toString(new PostDocument(postDto));
//        System.out.println(doc);
        index.addDocuments(doc);
//        System.out.println("추가");
    }

    public void clear() {
        getIndex().deleteAllDocuments();
    }
}
