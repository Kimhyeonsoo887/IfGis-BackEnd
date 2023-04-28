package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.CoordinateVO;
import com.group.ifgis.main.model.FoodStoreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MainRepository extends JpaRepository<FoodStoreDTO,Long>, MainRepositoryCom {

}
