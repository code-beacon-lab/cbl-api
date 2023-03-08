package org.api.beacon.study.domain;

import org.api.beacon.study.domain.Study;

import java.util.Optional;

public interface StudyReader {

    Optional<Study> getStudy(Long id);

}
