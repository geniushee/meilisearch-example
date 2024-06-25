package com.example.example_meilisearch.global.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String modelName; //meilisearch 사용시 Json 역직렬화에서 문제가 발생하여 필드를 명시

    public String getModelName(){
        String name = this.getClass().getSimpleName();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
