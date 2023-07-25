package com.group.ifgis.main.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity  // 객체와 테이블 매핑
@Table(name = "tb_user_log")
public class UserLogDTO {

    @Id // Primary Key 지정
    @GeneratedValue
    private Long id;

    @Column(name = "ip")  // 컬럼 지정
    private String ip;

    @Column(name = "create_date")  // 컬럼 지정
    @Temporal(TemporalType.DATE)
    private Date create_date = new Date();

    @Builder
    public UserLogDTO(String ip) {
        this.ip = ip;
    }

    public UserLogDTO() {

    }
}
