package com.jincrates.cogito.controller;

import com.jincrates.cogito.dto.BoardDTO;
import com.jincrates.cogito.dto.ReplyDTO;
import com.jincrates.cogito.service.ReplyService;
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
@RequestMapping("/reply/") @Api(tags = {"댓글 API"})
public class ReplyController {

    private final ReplyService service;  //자동주입을 위해 final

    @GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "댓글 리스트 조회")
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno) {

        log.info("Reply getListByBoard bno: {}", bno);

        return new ResponseEntity<>(service.getList(bno), HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "댓글 등록", response = ReplyDTO.class)
    public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO) {

        log.info("Reply register dto: {}", replyDTO);

        Long rno = service.register(replyDTO);

        return new ResponseEntity<>(rno, HttpStatus.OK);
    }

    @PutMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "댓글 수정", response = ReplyDTO.class)
    public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO) {

        log.info("Reply modify dto: {}", replyDTO);

        service.modify(replyDTO);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "댓글 삭제")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {

        log.info("Reply remove rno: {}", rno);

        service.remove(rno);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
