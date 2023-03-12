package org.api.beacon.reply.infrastructure.store;

import org.api.beacon.reply.domain.Reply;
import org.api.beacon.reply.domain.ReplyStore;
import org.api.beacon.reply.infrastructure.ReplyRepository;
import org.springframework.stereotype.Component;

@Component
public class ReplyStoreImpl implements ReplyStore {

    private final ReplyRepository replyRepository;

    public ReplyStoreImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public Reply updateReply(Reply reply) {
        return replyRepository.save(reply);
    }

    private void vaildate(Reply reply) {
        if(reply.getReplyDetail() == null) {
            throw new IllegalArgumentException("reply.replyDetail");
        }
    }

    private void vaildate(Long id) {
        if(id == null || id == 0) {
            throw new IllegalArgumentException("reply.id");
        }
    }
}
