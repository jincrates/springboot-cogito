package com.jincrates.cogito.service;

import com.jincrates.cogito.dto.BoardDTO;
import com.jincrates.cogito.entity.Board;
import com.jincrates.cogito.entity.Member;
import com.jincrates.cogito.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;  //자동 주 final

    @Override
    public Long register(BoardDTO dto) {

        Board board = dtoToEntity(dto);

        log.info("BoardServiceImpl : register.............................................");
        log.info(board);

        repository.save(board);

        return board.getBno();
    }

    @Override
    public BoardDTO get(Long bno) {

        Optional<Board> result = repository.getBoardByBno(bno);
        log.info("BoardServiceImpl : get.............................................");

        if(result.isPresent()) {
            return entityToDTO(result.get());
        }

        return null;
    }

    @Transactional
    @Override
    public void removeWIthReplies(Long bno) { //삭제 기능 구현, 트랜잭션 추가

        //댓긃부터 삭제
        //replyRepository.deleteByBno(bno);

        repository.deleteById(bno);
    }

    @Transactional
    @Override
    public void modify(BoardDTO boardDTO) {

        Board board = repository.getById(boardDTO.getBno());

        board.changeTitle(boardDTO.getTitle());
        board.changeContent(board.getContent());

        repository.save(board);
    }
}
