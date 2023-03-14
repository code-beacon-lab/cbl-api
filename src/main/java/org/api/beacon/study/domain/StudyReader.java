package org.api.beacon.study.domain;

import java.util.Optional;

public interface StudyReader {

    Optional<Study> getStudy(Long id);
}
