package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.FoodStoreDTO;
import com.group.ifgis.main.model.UserLogDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogRepository extends JpaRepository<UserLogDTO,Long> {
}
