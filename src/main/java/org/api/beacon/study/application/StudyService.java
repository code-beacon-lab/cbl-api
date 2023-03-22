package org.api.beacon.study.application;

import org.api.beacon.study.domain.Study;
import org.api.beacon.study.interfaces.StudyRequestDto;
import org.api.beacon.study.interfaces.StudyResponseDto;

import java.util.List;

public interface StudyService {

    Study createStudy(Study study);
    StudyResponseDto retrieveStudy(Long id);
    List<StudyResponseDto> retrieveStudies(String regId);
    StudyResponseDto modifyStudy(Long id, StudyRequestDto studyRequestDto);
    Boolean deleteStudy(Long id);
}
