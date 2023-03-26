package org.api.beacon.study.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonTime {   // 날짜 공통컬럼 class
    @CreatedDate
    @Column(name = "crt_dt")
    private String crtDt;   //생성일자 YYYY-MM-DD 00:00 형식

    @LastModifiedDate
    @Column(name = "upd_dt")
    private String updDt;

    // 엔티티 INSERT 전에 데이터 format 변경하여 넣기
    // PrePersist , PreUpdate 어노테이션 참고
    @PrePersist
    public void onPrePersist(){
        this.crtDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.updDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    @PreUpdate
    public void onPreUpdate(){
        this.updDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
