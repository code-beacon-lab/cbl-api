package org.api.beacon.reply.interfaces;

import org.api.beacon.reply.application.ReplyService;
import org.api.beacon.reply.domain.Reply;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping(value = "/reply")
@Controller
public class ReplyApiController {

    private final ReplyService replyService;

    public ReplyApiController(ReplyService replyService) {
        this.replyService = replyService;
    }

    // 게시물에 대한 댓글 전체 조회
    @GetMapping(value="/{studyId}")
    public ResponseEntity<List<Reply>> retrieveAllReply(@PathVariable("studyId") String studyId) {
        return ResponseEntity.ok(replyService.retrieveAllReply(Long.valueOf(studyId)));
    }

    // 댓글 삽입
    @PostMapping
    public ResponseEntity<Reply> createReply(@RequestBody ReplyRequestDto replyRequestDto) {
        Reply newReply = replyService.createReply(replyRequestDto);
        WebMvcLinkBuilder selfLinkBuilder = linkTo(ReplyApiController.class).slash(newReply.getId());
        URI createUri = selfLinkBuilder.toUri();
        return ResponseEntity.created(createUri).body(newReply);
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<Reply> updateReply(@RequestBody ReplyRequestDto replyRequestDto) {
        Reply newReply = replyService.updateReply(replyRequestDto);
        WebMvcLinkBuilder selfLinkBuilder = linkTo(ReplyApiController.class).slash(newReply.getId());
        URI updateUri = selfLinkBuilder.toUri();
        return ResponseEntity.created(updateUri).body(newReply);
    }
}