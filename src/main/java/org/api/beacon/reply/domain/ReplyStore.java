package org.api.beacon.reply.domain;

public interface ReplyStore {
    // 댓글 작성
    Reply saveReply(Reply reply);

    // 댓글 수정
    Reply updateReply(Reply reply);
}
