package com.group.ifgis.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
@Entity  // 객체와 테이블 매핑
@Table(name = "tb_foodstore")
public class FoodStoreDTO {


    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.AUTO)  // AUTO_INCREMENT 설정 (id값이 null일 경우 자동 생성)
    @Column(name = "id")  // 컬럼 지정
    private Long id;

    @NotNull
    @Column(name = "store_name")
    private String storeName;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "store_type")
    private String storeType;


    @NotNull
    @Column(name = "payment_mtd")
    private String paymentMtd;


    @NotNull
    @Column(name = "app_time")
    private String appTime;


    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Column(name = "la")
    private Double la;

    @NotNull
    @Column(name = "ma")
    private Double ma;


    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
    @JoinColumn(name="food_fk")
    private Collection<ReviewDTO> review;

}
