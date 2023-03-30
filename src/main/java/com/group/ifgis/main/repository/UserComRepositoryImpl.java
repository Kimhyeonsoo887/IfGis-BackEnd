package com.group.ifgis.main.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserComRepositoryImpl implements UserComRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Long findByUserId(String user_id) {
        System.out.println("===== Post Custom Repository 메소드명: findByUserId ===="); // 확인하기 위해서 print

        Long result = em.createQuery("SELECT count(u) FROM UserVO u WHERE u.user_id = :user_id", Long.class)
                        .setParameter("user_id", user_id)
                        .getSingleResult();

        return result;

    }

    @Override
    public String findBySecurityPassword(String user_id) {
        System.out.println("===== Post Custom Repository 메소드명: findBySecurityPassword ====");

        String result = em.createQuery("SELECT u.password FROM UserVO u WHERE u.user_id = :user_id", String.class)
                .setParameter("user_id", user_id)
                .getSingleResult();

        return result;

    }
}
