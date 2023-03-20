package com.group.ifgis.main.controller;

import com.group.ifgis.main.model.CoordinateVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

//    @GetMapping("list")
//    public ResponseEntity<List<Member>> getMembers() {
//        List<Member> members = memberService.getMembers();
//        return new ResponseEntity<>(members, HttpStatus.OK);
//    }
    @GetMapping("/getCoordinate")
    public ResponseEntity<List<CoordinateVO>> getCoordinate(){


        return null;
    }
}
