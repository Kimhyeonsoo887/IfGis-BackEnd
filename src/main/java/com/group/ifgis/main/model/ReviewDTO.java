package com.group.ifgis.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity  // 객체와 테이블 매핑
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
@Table(name = "tb_review")
public class ReviewDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "ori_file_name")
    private String oriFileName;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate = new Date();

    @Column(name = "food_fk")
    private Long foodFk;


    @Builder
    public ReviewDTO(Long id, String title, String content, String fileName, String oriFileName, Long foodFk) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.foodFk = foodFk;
        this.oriFileName = oriFileName;

    }

}
