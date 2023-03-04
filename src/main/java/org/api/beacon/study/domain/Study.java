package org.api.beacon.study.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "TB_STUDY")
@Getter //@Setter 제거 -> 생성자방식으로 주입
public class Study extends CommonTime {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)   //MySQL - auto_increment setting
    @Column(name = "study_id")
    //@NotNull //TODO 적용시 auto increment 안되는 현상
    private Long id;

    @Column(name = "study_name")
    @NotBlank(message = "스터티명 미기재 오류")
    private String name;

    @Column(name = "study_desc")
    @NotBlank(message = "스터티 설명 미기재 오류")
    private String description;

    @Column(name = "recruit_limit")
    @NotNull(message = "스터티인원 제한 미기재 오류")
    private Long limit;

    @Column(name = "reg_id")
    @NotBlank(message = "스터티생성자 미기재 오류")
    private String reg_id;

    @Column(name = "recruitment_dt")
    private String recruitment_dt;   //YYYY-MM-DD 00:00:00 형식

// 생성일자 : TODO - CommonTime class 사용 예정
//    @Column(name = "crt_dt")
//    private LocalDateTime crt_dt;   //YYYY-MM-DD 00:00:00 형식

    @Column(name = "deadline_dt")
    private String deadline_dt;   //YYYY-MM-DD 00:00:00 형식

    @Column(name = "end_dt")
    private String end_dt;   //YYYY-MM-DD 00:00:00 형식

    @Builder
    public void Study(Long id, String name, String description, Long limit, String reg_id, String recruitment_dt, String deadline_dt, String end_dt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.limit = limit;
        this.reg_id = reg_id;
        this.recruitment_dt = recruitment_dt;
        this.deadline_dt = deadline_dt;
        this.end_dt = end_dt;
    }
    @Builder
    public void updateStudy(String name, String description, Long limit) {
        this.name = name;
        this.description = description;
        this.limit = limit;
    }

    @Builder
    public void updateStudy(String description, Long limit) {
        this.description = description;
        this.limit = limit;
    }
}
