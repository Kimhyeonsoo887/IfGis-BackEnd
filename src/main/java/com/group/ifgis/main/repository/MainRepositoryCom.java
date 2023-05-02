package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.CodeDTO;
import com.group.ifgis.main.model.FoodStoreDTO;
import org.springframework.data.repository.NoRepositoryBean;

public interface MainRepositoryCom {

    FoodStoreDTO getFoodStoreDetailData(Long id);

}
