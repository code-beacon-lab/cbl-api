package org.api.beacon.study.infrastructure.reader;

import org.api.beacon.study.domain.Study;

import java.util.Optional;

public interface StudyReader {

    Optional<Study> getStudy(Long id);

}
