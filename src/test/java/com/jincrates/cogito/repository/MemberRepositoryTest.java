package com.jincrates.cogito.repository;

import com.jincrates.cogito.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                    .email("member" + i + "@cogito.com")
                    .password("1111")
                    .name("USER" + i)
                    .build();

            memberRepository.save(member);
        });

    }
}