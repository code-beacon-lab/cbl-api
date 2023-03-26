package org.api.beacon.study.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.api.beacon.study.domain.Study;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class StudyResponseDto {
    private Long id;
    private String name;
    private String regId;
    private String description;
    private Long limit;
    private String recruitmentDt;
    private String deadlineDt;
    private String endDt;
    private String crtDt;

    public StudyResponseDto(Study study) {
        this.id = study.getId();
        this.name = study.getName();
        this.regId = study.getRegId();
        this.description = study.getDescription();
        this.limit = study.getLimit();
        this.recruitmentDt = study.getRecruitmentDt();
        this.deadlineDt = study.getDeadlineDt();
        this.endDt = study.getEndDt();
        this.crtDt = study.getCrtDt();
    }
}
