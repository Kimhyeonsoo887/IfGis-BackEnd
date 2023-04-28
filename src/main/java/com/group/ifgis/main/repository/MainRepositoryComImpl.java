package com.group.ifgis.main.repository;
import com.group.ifgis.main.model.FoodStoreDTO;
import com.group.ifgis.main.model.QFoodStoreDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.group.ifgis.main.model.QFoodStoreDTO.foodStoreDTO;

@RequiredArgsConstructor
public class MainRepositoryComImpl implements MainRepositoryCom{

    private final JPAQueryFactory queryFactory;


    @Override
    public FoodStoreDTO getFoodStoreDetailData(Long id) {

        return queryFactory.selectFrom(foodStoreDTO)
                .where(foodStoreDTO.id.eq(id))
                .fetchFirst();

    }
}
