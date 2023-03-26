package org.api.beacon.front;

import lombok.RequiredArgsConstructor;
import org.api.beacon.reply.application.ReplyService;
import org.api.beacon.reply.domain.Reply;
import org.api.beacon.study.application.StudyService;
import org.api.beacon.study.domain.Study;
import org.api.beacon.study.interfaces.StudyResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor    //생성자 관련 어노테이션
@RequestMapping(value = "/front")
public class FrontController {  //타임리프 테스트용 프론트 페이지 컨트롤러

    private final StudyService studyService;
    private final ReplyService replyService;

    @GetMapping(value = "/study/{id}") // 스터디 상세페이지(수정,삭제)
    public ModelAndView getStudyPage(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView();
        StudyResponseDto study = studyService.retrieveStudy(id);
        List<Reply> replyList = replyService.retrieveAllReply(id);

        mav.addObject("study", study);
        mav.addObject("replyList", replyList);
        mav.setViewName("study");
        return mav;
    }

    @GetMapping(value = "/studies") // 스터디 목록 페이지
    public ModelAndView getStudiesPage(){
        ModelAndView mav = new ModelAndView();
        List<Study> studyList = studyService.retrieveStudies();
        mav.addObject("studyList", studyList);
        mav.setViewName("studylist");
        return mav;
    }

}
