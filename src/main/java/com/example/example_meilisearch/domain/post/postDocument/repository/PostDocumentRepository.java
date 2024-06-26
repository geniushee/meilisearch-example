package com.example.example_meilisearch.domain.post.postDocument.repository;

import com.example.example_meilisearch.domain.post.post.dto.PostDto;
import com.example.example_meilisearch.domain.post.postDocument.entity.PostDocument;
import com.example.example_meilisearch.global.app.AppConfig;
import com.example.example_meilisearch.global.meiliSearch.MeiliConfig;
import com.example.example_meilisearch.global.ut.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meilisearch.sdk.Index;
import com.meilisearch.sdk.SearchRequest;
import com.meilisearch.sdk.exceptions.MeilisearchException;
import com.meilisearch.sdk.model.Results;
import com.meilisearch.sdk.model.Searchable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDocumentRepository {
    // docker 볼륨에 저장되는 형태이기때문에 레포지터리 형태로 구현하여 docs를 저장
    private final MeiliConfig meiliConfig;
    private Index postIndex;

    public String getIndexName(){
        String indexName = "post";
        if(AppConfig.isTest()) indexName += "Test";
        return indexName;
    }

    public Index getIndex(){
        if(postIndex == null) postIndex = meiliConfig.meiliSearchClient().index(getIndexName());

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
        getIndex().resetSortableAttributesSettings();
        getIndex().updateSortableAttributesSettings(new String[]{"id"});
    }

    public Results<PostDocument> findAll() {
        Results<PostDocument> posts = getIndex().getDocuments(PostDocument.class);

        return posts;
    }

    public List<PostDocument> findAllByOrderByIdDesc() {

        SearchRequest request = new SearchRequest("").setSort(new String[]{"id:desc"});
        Searchable results = getIndex().search(request);
        return results.getHits().stream().map(hit -> Util.Json.toObject(hit, PostDocument.class)).toList();
    }


    public Optional<PostDocument> findById(Long id) {
        try {
            // 없는 자료를 찾을 때는 에러가 발생하는데 에러의 내용이 별도의 에러 객체가 생성되면서 PostDocument에 포함되지 않는 필드를 요구함.
            // 별도의 처리 방법이 필요.
            PostDocument postDoc = getIndex().getDocument(String.valueOf(id), PostDocument.class);
            return Optional.ofNullable(postDoc);
        }catch (MeilisearchException ignored){

        }
        return Optional.empty();
    }
}
