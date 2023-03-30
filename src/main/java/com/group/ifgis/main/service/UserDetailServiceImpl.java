package com.group.ifgis.main.service;

import com.group.ifgis.main.repository.UserComRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserComRepository userComRepository;

    public UserDetailServiceImpl(UserComRepository userComRepository) {
        this.userComRepository = userComRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Long checkUserInfoCnt = userComRepository.findByUserId(username);
        if (checkUserInfoCnt == 0) new UsernameNotFoundException("등록되지 않은 사용자 입니다");

        return null;
    }
}
