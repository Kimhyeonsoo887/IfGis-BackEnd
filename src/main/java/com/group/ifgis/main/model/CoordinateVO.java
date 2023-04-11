package com.group.ifgis.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
@Entity  // 객체와 테이블 매핑
@Table(name = "tb_coordinate")
public class CoordinateVO {

    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq")  // 컬럼 지정
    private Long seq;

    @NotNull
    @Column(name = "coordinate_name")
    private String coordinate_name;

    @NotNull
    @Column(name = "coordinate_x")
    private Double coordinate_x;

    @NotNull
    @Column(name = "coordinate_y")
    private Double coordinate_y;

}
