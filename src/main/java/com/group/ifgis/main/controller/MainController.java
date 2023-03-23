package com.group.ifgis.main.controller;

import com.group.ifgis.main.model.CoordinateVO;
import com.group.ifgis.main.model.UserVO;
import com.group.ifgis.main.repository.MainRepository;
import com.group.ifgis.main.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {

    private final MainRepository mainRepository;
    private final UserRepository userRepository;


    @GetMapping("/getCoordinate")
    public List<CoordinateVO> getCoordinate(){

        List<CoordinateVO> resultCoordinateVO = mainRepository.findAll();
        
        return resultCoordinateVO;
    }

    @PostMapping("/signUp")
    public Long signUp(@RequestBody UserVO userVO){


        userVO = userRepository.save(userVO);

        return userVO.getId();
    }
}
