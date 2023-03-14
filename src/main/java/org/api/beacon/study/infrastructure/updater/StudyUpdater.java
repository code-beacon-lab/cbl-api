package org.api.beacon.study.infrastructure.updater;

import org.api.beacon.study.domain.Study;

public interface StudyUpdater {

    Study updateStudy(Long id, Study study);
    void deleteStudy(Long id);

}
