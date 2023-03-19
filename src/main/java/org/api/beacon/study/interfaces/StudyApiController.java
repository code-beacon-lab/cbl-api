package org.api.beacon.study.interfaces;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.application.StudyService;
import org.api.beacon.study.domain.Study;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class StudyApiController {

    private final StudyService studyService;

    @PostMapping(value = "/studies")
    public Study createStudy(@RequestBody Study study) {
        studyService.createStudy(study);
        return study;
    }

    @GetMapping(value = "/studies/{id}")
    public ResponseEntity<StudyResponseDto> retrieveStudy(@PathVariable("id") String id) {
        return ResponseEntity.ok(studyService.retrieveStudy(Long.valueOf((id))));
    }

    @GetMapping(value = "/studies/list/{regId}")
    public ResponseEntity<Object> retrieveStudies(@PathVariable("regId") String regId) {
        //TODO Object 타입 반환 방법이 아닌 다른 방식이 있을지 고민
        if(studyService.retrieveStudies(regId).isEmpty()) return ResponseEntity.badRequest().body("해당 ID : " + regId + " 로 등록된 스터디가 없습니다.");
        else return ResponseEntity.ok(studyService.retrieveStudies(regId));
    }

    @PutMapping(value = "/studies/{id}")
    public ResponseEntity<StudyResponseDto> modifyStudy(@PathVariable("id") String id, @RequestBody Study study) {
        return ResponseEntity.ok(studyService.modifyStudy(Long.valueOf(id), study));
    }

    @DeleteMapping(value = "/studies/{id}")
    Boolean deleteStudy(@PathVariable("id") String id) {
        return studyService.deleteStudy(Long.valueOf(id));
    }

}
