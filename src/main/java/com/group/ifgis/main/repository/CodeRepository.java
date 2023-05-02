package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.CodeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<CodeDTO,Long> {
}
