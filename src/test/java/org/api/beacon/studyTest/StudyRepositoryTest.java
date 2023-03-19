package org.api.beacon.studyTest;

import org.api.beacon.study.domain.Study;
import org.api.beacon.study.domain.StudyCreator;
import org.api.beacon.study.infrastructure.StudyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyRepositoryTest {

    @Autowired
    StudyRepository studyRepository;

    @Autowired
    StudyCreator studyCreator;

    @Test
    @Rollback(false)
    public void saveStudyTest() {
        Study study = Study.builder()
                .id(1L)
                .name("스터티이름")
                .description("스터디설명입니다.")
                .limit(10L)
                .regId("kodh10")
                .recruitmentDt("2023-02-26")
//                .crt_dt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .deadlineDt("2023-03-26")
                .endDt("2023-03-29")
                .build();

        studyCreator.saveStudy(study);
        Optional<Study> getStudy = studyRepository.findById(study.getId());
}





}
