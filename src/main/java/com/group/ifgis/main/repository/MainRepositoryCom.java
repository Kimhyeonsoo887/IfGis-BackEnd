package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.BoardDTO;
import com.group.ifgis.main.model.FoodStoreDTO;

public interface MainRepositoryCom {

    FoodStoreDTO getFoodStoreDetailData(Long id);
}
