package org.api.beacon.reply.application;

import org.api.beacon.reply.domain.Reply;
import org.api.beacon.reply.interfaces.ReplyResponseDto;

import java.util.List;

public interface ReplyService {
    ReplyResponseDto retrieveReply(Long requestDto);
    List<Reply> retrieveAllReply(Long studyId);
    void createReply(Reply reply);
    Reply updateReply(Long id, Reply reply);
}
