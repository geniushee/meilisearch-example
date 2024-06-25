package com.example.example_meilisearch.domain.member.member.repository;

import com.example.example_meilisearch.domain.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
