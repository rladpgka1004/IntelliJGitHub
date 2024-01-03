package com.example.board.controller;

import com.example.board.dto.BoardDTO;
import com.example.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class BoradController {
    private BoardService boardService;

    public BoradController(BoardService boardService){
        this.boardService = boardService;
    }


    @GetMapping("/")
//    getBoardList로 가져온 데이터를 Model을 통해 View에 전달
    public String list(Model model) {
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("postList", boardDTOList);
        return "board/list"; // model에 추가된 boardDTOList인 postList를 board/list에 전달
    }

    @GetMapping("/post")
    public String post(){

        return "board/post";
    }


    @PostMapping("/post")
    public String write(BoardDTO boardDTO){
        log.info("boardDTO.getContent() = {}", boardDTO.getContent());
        log.info("boardDTO.getContent() = {}", boardDTO.getContent());
        log.info("boardDTO.getMember() = {}", boardDTO.getMember());
        log.info("boardDTO.getMember() = {}", boardDTO.getMember());
        log.info("boardDTO.getTitle() = {}", boardDTO.getTitle());
        log.info("boardDTO.getTitle() = {}", boardDTO.getTitle());
        boardService.savePost(boardDTO);
        return "redirect:/";
    }
}
