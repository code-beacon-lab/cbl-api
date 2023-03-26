package org.api.beacon.study.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StudyRequestDto {

    private String name;
    private String description;
    private Long limit;
    private String recruitmentDt;
    private String deadlineDt;
    private String endDt;

}
