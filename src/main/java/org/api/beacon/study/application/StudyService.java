package org.api.beacon.study.application;

import org.api.beacon.study.domain.Study;

import java.util.List;
import java.util.Optional;

public interface StudyService {

    Study createStudy(Study study);
    Optional<Study> retrieveStudy(Long id);
    List<Study> retrieveStudies();
    Study modifyStudy(Long id, Study study);
    Boolean deleteStudy(Long id);
}
