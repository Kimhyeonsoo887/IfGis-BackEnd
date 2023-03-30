package com.group.ifgis.main.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity  // 객체와 테이블 매핑
@Table(name = "tb_users")
public class UserVO implements UserDetails {

    @Id // Primary Key 지정
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")  // 컬럼 지정
    private String user_id;

    @Column(name = "password")  // 컬럼 지정
    private String password;

    @Column(name = "user_name")  // 컬럼 지정
    private String username;

    @Column(name = "create_date")
    private Date create_date = new Date();

    @Column(name = "role")
    private String role = "USER"; // 사용자 권한


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return role;
            }
        });
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
