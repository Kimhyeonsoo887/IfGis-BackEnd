package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.ReviewDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReviewComRepositoryImpl implements ReviewComRepository{

    private final JPAQueryFactory queryFactory;


    @Override
    public List<ReviewDTO> getReviewData() {

        return null;
    }
}
