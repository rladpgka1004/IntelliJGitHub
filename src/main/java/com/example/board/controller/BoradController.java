package com.example.board.controller;

import com.example.board.dto.BoardDTO;
import com.example.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.getPost(id);
        model.addAttribute("post", boardDTO);
        return "board/detail";
    }


    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.getPost(id);
        model.addAttribute("post", boardDTO);
        return "board/edit";
    }

//   수정된 게시글을 서버에 input하여 db에 저장하기위한 update
    @PutMapping("/post/edit/{id}")
    public String update(BoardDTO boardDTO){
        boardService.savePost(boardDTO);
        return "redirect:/";
    }


    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id){
        boardService.deletePost(id);
        return "redirect:/";
    }
}
