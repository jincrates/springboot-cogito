package com.jincrates.cogito.controller;

import com.jincrates.cogito.dto.BoardDTO;
import com.jincrates.cogito.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;  //final

    @PostMapping(value = "")
    public ResponseEntity<Long> register(@RequestBody BoardDTO boardDTO) {

        log.info("BoardController : register.............................................");
        log.info(boardDTO);

        Long bno = service.register(boardDTO);

        return new ResponseEntity<>(bno, HttpStatus.OK);
    }

    @GetMapping(value = "/{bno}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public ResponseEntity<BoardDTO> read(@PathVariable("bno") Long bno) {
        log.info("BoardController : read.............................................");
        log.info(bno);

        return new ResponseEntity<>(service.get(bno), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public ResponseEntity<List<BoardDTO>> getList(String email) {
        log.info("getList................................................................");
        log.info(email);

        return new ResponseEntity<>(service.getAllWithWriter(email), HttpStatus.OK);
    }

    @PutMapping(value = "/{bno}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> modify(@RequestBody BoardDTO boardDTO) {
        log.info("modify..................................................................");
        log.info(boardDTO);

        service.modify(boardDTO);

        return new ResponseEntity<>("modified", HttpStatus.OK);
    }
}
