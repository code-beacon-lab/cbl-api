package org.api.beacon.study.interfaces;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.application.StudyService;
import org.api.beacon.study.domain.Study;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api")
@RestController
@RequiredArgsConstructor
public class StudyApiController {

    private final StudyService studyService;

    @PostMapping(value = "/studies")
    public Study createStudy(@RequestBody Study study) {
        studyService.createStudy(study);
        return study;
    }

    @GetMapping(value = "/studies/{id}")
    public ResponseEntity<Optional<Study>> retrieveStudy(@PathVariable("id") String id) {
        return ResponseEntity.ok(studyService.retrieveStudy(Long.valueOf((id))));
    }

    @GetMapping(value = "/studies")
    public List<Study> retrieveStudies() {
        return studyService.retrieveStudies();
    }

    @PutMapping(value = "/studies/{id}")
    public Study modifyStudy(@PathVariable("id") String id, @RequestBody Study study) {
        return studyService.modifyStudy(Long.valueOf(id), study);
    }

    @DeleteMapping(value = "/studies/{id}")
    Boolean deleteStudy(@PathVariable("id") String id) {
        return studyService.deleteStudy(Long.valueOf(id));
    }

}
