package com.group.ifgis.main.repository;

public interface UserComRepository {

    Long findByUserId(String user_id);

    String findBySecurityPassword(String user_id);
}
