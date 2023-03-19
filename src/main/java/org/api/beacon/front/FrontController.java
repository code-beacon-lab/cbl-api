package org.api.beacon.front;

import lombok.RequiredArgsConstructor;
import org.api.beacon.study.application.StudyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor    //생성자 관련 어노테이션
@RequestMapping(value = "/front")
public class FrontController {  //타임리프 테스트용 프론트 페이지 컨트롤러

    private final StudyService studyService;

    @GetMapping(value = "/study/{id}")
    public ModelAndView getStudyPage(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("study", studyService.retrieveStudy(id));
        mav.setViewName("study");
        return mav;
    }

}
