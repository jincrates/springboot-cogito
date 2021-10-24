package com.jincrates.cogito.repository;

import com.jincrates.cogito.entity.Board;
import com.jincrates.cogito.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository repository;

    @Test
    public void insertBoard() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            //MemberRepository에 미리 생성되어 있어야함
            User user = User.builder()
                    .email("user" + i + "@cogito.com")
                    //.password("1111")
                    //.name("사용자" + i)
                    .build();

            Board board = Board.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer(user)
                    .build();

            repository.save(board);
        });
    }
}