package org.api.beacon.study.infrastructure.updater;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.domain.Study;
import org.api.beacon.study.infrastructure.StudyRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudyUpdaterImpl implements StudyUpdater {

    private final StudyRepository studyRepository;

    @Override
    public Study updateStudy(Long id, Study study) {
        return studyRepository.save(study);
    }

    @Override
    public void deleteStudy(Long id) {
        studyRepository.deleteById(id);
    }
}
