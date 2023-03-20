package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.CoordinateVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<CoordinateVO,Long> {


}
