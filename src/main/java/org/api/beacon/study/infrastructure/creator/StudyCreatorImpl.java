package org.api.beacon.study.infrastructure.creator;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.domain.Study;
import org.api.beacon.study.domain.StudyCreator;
import org.api.beacon.study.infrastructure.StudyRepository;
import org.springframework.stereotype.Component;

import static java.time.LocalTime.now;


@Component
@RequiredArgsConstructor
public class StudyCreatorImpl implements StudyCreator {

    private final StudyRepository studyRepository;

    @Override
    public void saveStudy(Study study) {
        studyRepository.save(study);
    }

}
