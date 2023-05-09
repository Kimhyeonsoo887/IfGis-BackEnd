package com.group.ifgis.main.service;

import com.group.ifgis.main.model.ReviewDTO;
import com.group.ifgis.main.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.group.ifgis.main.common.ComConfig.uploadDir;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Long reviewSaveFile(ReviewDTO reviewDTO, MultipartFile files) throws IOException {


        if(files != null){
            // 원래 파일 이름 추출
            String origName = files.getOriginalFilename();

            // 파일 이름으로 쓸 uuid 생성
            String uuid = UUID.randomUUID().toString();

            // 확장자 추출(ex : .png)
            String extension = origName.substring(origName.lastIndexOf("."));

            // uuid와 확장자 결합
            String savedName = uuid + extension;

            // 파일을 불러올 때 사용할 파일 경로
            String savedPath = uploadDir + savedName;

            // 실제로 로컬에 uuid를 파일명으로 저장
            files.transferTo(new File(savedPath));

            reviewDTO.setFileName(savedName);
            reviewDTO.setOriFileName(origName);
        }
        // 데이터베이스에 파일 정보 저장 
        ReviewDTO resultFile = reviewRepository.save(reviewDTO);

        return resultFile.getId();
    }
    

}
