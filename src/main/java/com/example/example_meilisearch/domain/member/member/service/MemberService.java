package com.example.example_meilisearch.domain.member.member.service;

import com.example.example_meilisearch.domain.member.member.entity.Member;
import com.example.example_meilisearch.domain.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member register(String username, String password, String nickname){
        Member member = Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
        return memberRepository.save(member);
    }
}
