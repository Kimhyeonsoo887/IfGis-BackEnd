package com.group.ifgis.main.controller;

import com.group.ifgis.main.model.BoardDTO;
import com.group.ifgis.main.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardRepository boardRepository;


    @GetMapping("/getBoardList")
    public List<BoardDTO> getBoardList(){

        List<BoardDTO> resultList = boardRepository.findAll();

        return resultList;
    }

    @PostMapping("/getBoardDetail")
    public Object getBoardDetail(@RequestBody BoardDTO boardDTO){

        if(boardDTO.getId() == null){
            return "404Error";
        }

        Optional<BoardDTO> resultDTO = boardRepository.findById(boardDTO.getId());

        resultDTO.ifPresent(selectBoard-> {
            selectBoard.setBoard_cnt(resultDTO.get().getBoard_cnt() +1);
            boardRepository.save(selectBoard);
        });
        return resultDTO;

    }
}
