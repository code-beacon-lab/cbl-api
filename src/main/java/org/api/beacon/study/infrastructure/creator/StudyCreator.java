package org.api.beacon.study.infrastructure.creator;

import org.api.beacon.study.domain.Study;
import org.api.beacon.study.infrastructure.StudyRepository;

public interface StudyCreator {

    public void saveStudy(Study study);

}
