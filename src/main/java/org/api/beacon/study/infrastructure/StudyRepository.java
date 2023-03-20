package org.api.beacon.study.infrastructure;

import org.api.beacon.study.domain.Study;
import org.api.beacon.study.interfaces.StudyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudyRepository extends JpaRepository<Study, Long> {
    List<StudyResponseDto> findAllByRegId(String regId);
}
