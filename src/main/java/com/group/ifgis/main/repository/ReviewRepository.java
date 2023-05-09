package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.ReviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewDTO,Long> {
}
