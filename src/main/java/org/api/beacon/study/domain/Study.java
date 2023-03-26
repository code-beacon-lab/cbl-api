package org.api.beacon.study.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "TB_STUDY")
@Getter //@Setter 제거 -> 생성자방식으로 주입
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String regId;

    @Column(name = "recruitment_dt")
    private String recruitmentDt;   //YYYY-MM-DD 00:00:00 형식

// 생성일자 : TODO - CommonTime class 사용 예정
//    @Column(name = "crt_dt")
//    private LocalDateTime crt_dt;   //YYYY-MM-DD 00:00:00 형식

    @Column(name = "deadline_dt")
    private String deadlineDt;   //YYYY-MM-DD 00:00:00 형식

    @Column(name = "end_dt")
    private String endDt;   //YYYY-MM-DD 00:00:00 형식

    public void Study(Study study) {
        this.id = study.getId();
        this.name = study.getName();
        this.description = study.getDescription();
        this.limit = study.getLimit();
        this.regId = study.getRegId();
        this.recruitmentDt = study.getRecruitmentDt();
        this.deadlineDt = study.getDeadlineDt();
        this.endDt = study.getEndDt();
    }
    public void updateStudy(String name, String description, Long limit) {
        this.name = name;
        this.description = description;
        this.limit = limit;
    }

    public void updateStudy(String description, Long limit) {
        this.description = description;
        this.limit = limit;
    }
}
