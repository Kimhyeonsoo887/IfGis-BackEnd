package com.group.ifgis.main.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BoardComRepositoryImpl implements BoardComRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public int updateBoardCnt() {


        return 0;
    }
}
