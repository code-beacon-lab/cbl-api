package org.api.beacon.reply.domain;

import java.util.List;

public interface ReplyReader {
    Reply getReplyById(Long replyId);
    List<Reply> getReplyAllByStudyId(Long studyId);
}
