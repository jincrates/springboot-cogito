package com.jincrates.cogito.service;

import com.jincrates.cogito.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardServiceImplTest {

    @Autowired
    private BoardService service;

    @Test
    public void testGet() {

        Long bno = 2L;

        BoardDTO boardDTO = service.get(bno);

        System.out.println(boardDTO);
    }
}