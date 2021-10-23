package com.jincrates.cogito.controller;

import com.jincrates.cogito.dto.BoardDTO;
import com.jincrates.cogito.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @Log4j2
@RequiredArgsConstructor
@RequestMapping("/board") @Api(tags = {"게시판 API"})
public class BoardController {

    private final BoardService service;  //final

    @PostMapping(value = "")
    @ApiOperation(value = "게시글 등록", response = BoardDTO.class)
    public ResponseEntity<Long> register(@RequestBody BoardDTO boardDTO) {

        log.info("Board register dto: {}", boardDTO);

        Long bno = service.register(boardDTO);

        return new ResponseEntity<>(bno, HttpStatus.OK);
    }

    @GetMapping(value = "/{bno}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    @ApiOperation(value = "게시글 조회")
    public ResponseEntity<BoardDTO> read(@PathVariable("bno") Long bno) {
        log.info("Board read bno: {}", bno);

        return new ResponseEntity<>(service.get(bno), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    @ApiOperation(value = "게시글 리스트 조회")
    public ResponseEntity<List<BoardDTO>> getList(String email) {
        log.info("Board getList: {}", email);

        return new ResponseEntity<>(service.getAllWithWriter(email), HttpStatus.OK);
    }

    @PutMapping(value = "/{bno}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "게시글 수정", response = BoardDTO.class)
    public ResponseEntity<String> modify(@RequestBody BoardDTO boardDTO) {
        log.info("Board modify dto: {}", boardDTO);

        service.modify(boardDTO);

        return new ResponseEntity<>("modified", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{bno}", produces =  MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "게시글 삭제")
    public ResponseEntity<String> remove(@PathVariable("bno") Long bno) {
        log.info("Board remove bno: {}", bno);

        service.remove(bno);

        return new ResponseEntity<>("remove", HttpStatus.OK);
    }
}



