package com.group.ifgis.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity  // 객체와 테이블 매핑
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
@Table(name = "tb_code")
public class CodeDTO {


    @Id
    @Column(name ="id")
    @GeneratedValue
    private Long id;

    @Column(name = "no")
    private int no;

    @Column(name = "code_no")
    private String code_no;

    @Column(name = "code_name")
    private String code_name;



}
