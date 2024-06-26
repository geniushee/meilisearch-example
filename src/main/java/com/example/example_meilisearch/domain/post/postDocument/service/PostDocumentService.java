package com.example.example_meilisearch.domain.post.postDocument.service;

import com.example.example_meilisearch.domain.post.post.dto.PostDto;
import com.example.example_meilisearch.domain.post.postDocument.entity.PostDocument;
import com.example.example_meilisearch.domain.post.postDocument.repository.PostDocumentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meilisearch.sdk.model.Results;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostDocumentService {
    private final PostDocumentRepository postDocumentRepository;

    public void addPostDocument(PostDto postDto) throws JsonProcessingException {
        postDocumentRepository.addPostDocument(postDto);
    }

    public void indexClear(){
        postDocumentRepository.clear();
    }

    public Results<PostDocument> findAll() {
        Results<PostDocument> posts = postDocumentRepository.findAll();
        return posts;
    }

    public List<PostDocument> findAllByOrderByIdDesc(){
        return postDocumentRepository.findAllByOrderByIdDesc();
    }

    public Optional<PostDocument> findById(Long id) {
        return postDocumentRepository.findById(id);
    }
}
