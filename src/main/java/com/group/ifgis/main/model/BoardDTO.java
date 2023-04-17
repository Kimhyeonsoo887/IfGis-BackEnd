package com.group.ifgis.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity  // 객체와 테이블 매핑
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
@Table(name = "tb_board")
public class BoardDTO {

    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "upload_id")
    private String upload_id;

    @Column(name = "board_cnt")
    private int board_cnt;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date create_date;

    @Column(name = "upload_date")
    @Temporal(TemporalType.DATE)
    private Date upload_date;



}
