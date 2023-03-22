package org.api.beacon.study.application.Impl;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.application.StudyService;
import org.api.beacon.study.domain.Study;
import org.api.beacon.study.domain.StudyCreator;
import org.api.beacon.study.domain.StudyReader;
import org.api.beacon.study.interfaces.StudyRequestDto;
import org.api.beacon.study.infrastructure.StudyRepository;
import org.api.beacon.study.infrastructure.updater.StudyUpdater;
import org.api.beacon.study.interfaces.StudyResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Study createStudy(Study study) {
        studyCreator.saveStudy(study);
        return study;
    }

    @Override
    @Transactional(readOnly = true)
    public StudyResponseDto retrieveStudy(Long id) {
        return new StudyResponseDto(studyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회할 ID 의 스터디가 없습니다 : " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudyResponseDto> retrieveStudies(String regId) {
        return studyRepository.findAllByRegId(regId);
    }

    @Override
    @Transactional
    public StudyResponseDto modifyStudy(Long id, StudyRequestDto studyRequestDto) {
        Study studyOrigin = studyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("업데이트할 ID 의 스터디가 없습니다 : "+id));
        studyOrigin.updateStudy(studyRequestDto);
        return new StudyResponseDto(studyUpdater.updateStudy(id, studyOrigin));
    }

    //TODO deleter 패키지를 만들것인가..?
    @Override
    @Transactional
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
