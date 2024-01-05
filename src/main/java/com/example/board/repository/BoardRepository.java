package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// findAll()등 다양한 메서드 사용가능 -> CRUD작업을 추상화 한 인터페이스
//                                                    매핑할 Entity와 id타입

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}

