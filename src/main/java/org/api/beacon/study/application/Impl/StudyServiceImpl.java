package org.api.beacon.study.application.Impl;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.application.StudyService;
import org.api.beacon.study.domain.Study;
import org.api.beacon.study.infrastructure.StudyRepository;
import org.api.beacon.study.domain.StudyCreator;
import org.api.beacon.study.domain.StudyReader;
import org.api.beacon.study.infrastructure.updater.StudyUpdater;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;
    private final StudyCreator studyCreator;
    private final StudyReader studyReader;
    private final StudyUpdater studyUpdater;

    @Override
    public Study createStudy(Study study) {
        studyCreator.saveStudy(study);
        return study;
    }

    @Override
    public Optional<Study> retrieveStudy(Long id) {
        return Optional.ofNullable(studyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회할 ID 의 스터디가 없습니다 : " + id)));
    }

    @Override
    public List<Study> retrieveStudies() {
        return studyRepository.findAll();
    }

    @Override
    public Study modifyStudy(Long id, Study study) {
        Study studyOrigin = studyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("업데이트할 ID 의 스터디가 없습니다 : "+id));
        // TODO 스터디 업데이트 시 들어오는 컬럼의 value 만 업데이트 하도록?
        // 현재는 name, desc, limit 정보가 있어야 업데이트가 가능
        // 모든 경우의 수에 대한 Builder 생성은 너무 비효율적..(스터디이름업데이트, 스터디 설명업데이트 ... 구분?)
        studyOrigin.updateStudy(study.getName(), study.getDescription(), study.getLimit());

        Study updateStudy = studyUpdater.updateStudy(id, studyOrigin);
        return updateStudy;
    }

    //TODO deleter 패키지를 만들것인가..?
    @Override
    public Boolean deleteStudy(Long id) {
        Optional<Study> study = studyRepository.findById(id);

        if(study.isPresent()){
            studyUpdater.deleteStudy(id);
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }


    }

}
