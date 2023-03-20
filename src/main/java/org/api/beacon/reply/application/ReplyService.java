package org.api.beacon.reply.application;

import org.api.beacon.reply.domain.Reply;
import org.api.beacon.reply.interfaces.ReplyRequestDto;
import org.api.beacon.reply.interfaces.ReplyResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyService {
    ReplyResponseDto retrieveReply(Long requestDto);
    List<Reply> retrieveAllReply(Long studyId);
    Reply createReply(ReplyRequestDto replyRequestDto);
    Reply updateReply(ReplyRequestDto replyRequestDto);
}
