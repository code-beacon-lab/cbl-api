package org.api.beacon.study.infrastructure;

import org.api.beacon.study.domain.Study;
import org.api.beacon.study.interfaces.StudyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;



public interface StudyRepository extends JpaRepository<Study, Long>, JpaSpecificationExecutor<StudyResponseDto> {

    // 사용자 기준 스터디 조회
    List<StudyResponseDto> findAllByRegId(String regId);
}
