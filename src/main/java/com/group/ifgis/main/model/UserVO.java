package com.group.ifgis.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity  // 객체와 테이블 매핑
@Table(name = "tb_users")
public class UserVO {

    @Id // Primary Key 지정
    @GeneratedValue
    @Column(name = "id")  // 컬럼 지정
    private Long id;

    @Column(name = "user_id")  // 컬럼 지정
    private String user_id;

    @Column(name = "password")  // 컬럼 지정
    private String password;

    @Column(name = "user_name")  // 컬럼 지정
    private String user_name;

    @Column(name = "create_date")
    private Date create_date = new Date();

}
