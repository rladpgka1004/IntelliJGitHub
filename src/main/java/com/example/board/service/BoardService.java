package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 글쓰기 버튼을 누르면 Post형식으로 요청 -> BoardService의 savePost실행
@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDTO boardDTO){
        return boardRepository.save(boardDTO.toEntity()).getId();
    }

    
    @Transactional     // 게시물 목록 가져오기, repository에서 데이터 조회 -> boardDTOList에 데이터 넣어 반환
    public List<BoardDTO> getBoardList(){ 
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntityList){
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(boardEntity.getId())
                    .member(boardEntity.getMember())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .createdDate(boardEntity.getCreatedData())
                    .build();
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }


    @Transactional
    // 게시글의 id를 받아 해당 게시글의 데이터만 가져와 뿌려줌
    public BoardDTO getPost(Long id){
        BoardEntity boardEntity = boardRepository.findById(id).get();

        BoardDTO boardDTO = BoardDTO.builder()
                .id(boardEntity.getId())
                .member(boardEntity.getMember())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .createdDate(boardEntity.getCreatedData())
                .build();
        return boardDTO;
    }

    @Transactional
//    /post/{id}로 요청받음 (1번 글에서 삭제를 클릭하면 /post/1로 접속
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }

}
