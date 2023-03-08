package org.api.beacon.study.infrastructure;

import org.api.beacon.study.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudyRepository extends JpaRepository<Study, Long> {

}
