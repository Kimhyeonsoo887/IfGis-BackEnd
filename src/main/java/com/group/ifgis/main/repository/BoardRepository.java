package com.group.ifgis.main.repository;

import com.group.ifgis.main.model.BoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<BoardDTO,Long> {
}
