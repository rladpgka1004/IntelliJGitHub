package com.example.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// JPA에게 해당 Entity는 Auditing(시간 자동 매핑)기능을 사용함을 알림
@EntityListeners(AuditingEntityListener.class) 
public class BoardEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 10, nullable = false)
    private String member;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdData;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder // null체크도 함
    public BoardEntity(Long id, String member, String title, String content){
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
    }

}
