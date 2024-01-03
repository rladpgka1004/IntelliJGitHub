package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//                                                    매핑할 Entity와 id타입
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
