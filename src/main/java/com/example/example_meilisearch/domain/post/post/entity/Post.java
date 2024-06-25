package com.example.example_meilisearch.domain.post.post.entity;

import com.example.example_meilisearch.domain.member.member.entity.Member;
import com.example.example_meilisearch.global.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTime {
    @ManyToOne
    private Member writer;
    private String title;
    private String content;
}
