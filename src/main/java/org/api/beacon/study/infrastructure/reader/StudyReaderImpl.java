package org.api.beacon.study.infrastructure.reader;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.domain.Study;
import org.api.beacon.study.infrastructure.StudyRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class StudyReaderImpl implements StudyReader {

    private final StudyRepository studyRepository;

    @Override
    public Optional<Study> getStudy(Long id) {
        return studyRepository.findById(id);
    }

}
