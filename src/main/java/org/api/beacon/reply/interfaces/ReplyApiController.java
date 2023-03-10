package org.api.beacon.reply.interfaces;

import org.api.beacon.reply.application.ReplyService;
import org.api.beacon.reply.domain.Reply;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/reply")
@Controller
public class ReplyApiController {

    private final ReplyService replyService;

    public ReplyApiController(ReplyService replyService) {
        this.replyService = replyService;
    }

    // 댓글 하나 조회(test)
    @GetMapping(value = "/replies12/{id}")
    public ResponseEntity<ReplyResponseDto> retrieveReply(@RequestBody String replyId) {
        return ResponseEntity.ok(replyService.retrieveReply(Long.valueOf(replyId)));
    }

    // 댓글 전체 조회
    @GetMapping(value = "/replies/{id}")
    public ResponseEntity<List<Reply>> retrieveAllReply(@PathVariable("id") String studyId) {
        System.out.println(studyId);
        return ResponseEntity.ok(replyService.retrieveAllReply(Long.valueOf(studyId)));
    }

    // 댓글 삽입
    @PostMapping(value = "/replies")
    public String createReply(@RequestBody Reply reply) {
        try {
            System.out.println(reply);
            replyService.createReply(reply);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    // 댓글 수정
    @PutMapping(value = "/replies/{id}")
    public Reply updateReply(@PathVariable("id") String id, @RequestBody Reply reply) {
        return replyService.updateReply(Long.valueOf(id), reply);
    }
}