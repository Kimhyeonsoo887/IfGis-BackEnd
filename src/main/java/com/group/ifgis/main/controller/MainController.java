package com.group.ifgis.main.controller;

import com.group.ifgis.main.common.JwtTokenProvider;
import com.group.ifgis.main.model.CodeDTO;
import com.group.ifgis.main.model.FoodStoreDTO;
import com.group.ifgis.main.model.UserVO;
import com.group.ifgis.main.repository.MainRepository;
import com.group.ifgis.main.repository.UserComRepository;
import com.group.ifgis.main.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.group.ifgis.main.component.ComAppRunner.codes;


@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    //메인 리포지토리
    private final MainRepository mainRepository;
    //유저 리포지토리 extends JpaRepository
    private final UserRepository userRepository;
    //유저 커스터마이징 extends UserComRepository
    private final UserComRepository userComRepository;
    private final JwtTokenProvider jwtTokenProvider;
    public final PasswordEncoder passwordEncoder;



    @GetMapping("/getFoodStoreData")
    public List<FoodStoreDTO> getFoodStoreData() {

        List<FoodStoreDTO> resultFoodStoreDTO = mainRepository.findAll();
        return resultFoodStoreDTO;
    }

    @PostMapping("/getFoodStoreDetailData")
    public FoodStoreDTO getFoodStoreDetailData(@RequestBody FoodStoreDTO foodStoreDTO){

        FoodStoreDTO resultDTO = mainRepository.getFoodStoreDetailData(foodStoreDTO.getId());

        String [] appTimes = resultDTO.getAppTime().split(",");
        String [] payMentMtd = resultDTO.getPaymentMtd().split(",");

        List<String> resultAppTimes = new ArrayList<>();
        List<String> resultPayMentMtd = new ArrayList<>();
        List<CodeDTO> codeNo2 = codes.stream()
                .filter(t -> t.getNo() == 2)
                .collect(Collectors.toList());

        for(int i=0; i<appTimes.length; i++){
            for(int e=0; e<codeNo2.size(); e++){
                if(appTimes[i].equals(codeNo2.get(e).getCode_no())){
                    resultAppTimes.add(codeNo2.get(e).getCode_name());
                }
            }
        }
        resultDTO.setAppTime(StringUtils.join(resultAppTimes, ','));


        List<CodeDTO> codeNo1 = codes.stream()
                .filter(t -> t.getNo() == 1)
                .collect(Collectors.toList());

        for(int i=0; i<payMentMtd.length; i++){
            for(int e=0; e<codeNo1.size(); e++){
                if(payMentMtd[i].equals(codeNo1.get(e).getCode_no())){
                    resultPayMentMtd.add(codeNo1.get(e).getCode_name());
                }
            }
        }
        resultDTO.setPaymentMtd(StringUtils.join(resultPayMentMtd, ','));

        return resultDTO;
    }


    @PostMapping("/signUp")
    public int signUp(@RequestBody UserVO userVO) {

        //아이디 중복체크 로직
        Long checkFindUserId = userComRepository.findByUserId(userVO.getUser_id());

        if(checkFindUserId != 0){
            return -1;
        }

        //패스워드 스프링 시큐리티 암호화 설정
        userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
        userVO = userRepository.save(userVO);

        if (userVO.getUser_id() != null) {
            return 1;
        }


        return 0;
    }

    @PostMapping("/login")
    public Object login(@RequestBody UserVO userVO){

        Map<String, Object> resultMap = new HashMap<>();

        //아이디 체크 로직
        Long checkUserIdCnt = userComRepository.findByUserId(userVO.getUser_id());
        if(checkUserIdCnt == 0) return "-1";

        //비밀번호 체크 로직
        String securityPassWord = userComRepository.findBySecurityPassword(userVO.getUser_id());
        Boolean pwdChk = passwordEncoder.matches(userVO.getPassword(), securityPassWord);

        if(!pwdChk) return "-2";

        resultMap.put("user_id", userVO.getUser_id());
        resultMap.put("token", jwtTokenProvider.createToken(userVO.getUsername(), userVO.getRole()));

        return resultMap;

    }

    @PostMapping("/insertFoodInformation")
    public Long insertFoodInformation(@RequestBody FoodStoreDTO foodStoreDTO){

        return mainRepository.save(foodStoreDTO).getId();
    }
}
