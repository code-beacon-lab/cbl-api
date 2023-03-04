package org.api.beacon.study.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonTime {   // 날짜 공통컬럼 class
    @CreatedDate
    @Column(name = "crt_dt")
    private String crt_dt;   //생성일자 YYYY-MM-DD 00:00 형식

    @LastModifiedDate
    @Column(name = "upd_dt")
    private String upd_dt;

    // 엔티티 INSERT 전에 데이터 format 변경하여 넣기
    // PrePersist , PreUpdate 어노테이션 참고
    @PrePersist
    public void onPrePersist(){
        this.crt_dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.upd_dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    @PreUpdate
    public void onPreUpdate(){
        this.upd_dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


}
