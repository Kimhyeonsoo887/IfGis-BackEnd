package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO,Long> {
}
