package org.api.beacon.reply.application.impl;

import org.api.beacon.reply.application.ReplyService;
import org.api.beacon.reply.domain.Reply;
import org.api.beacon.reply.domain.ReplyStore;
import org.api.beacon.reply.domain.ReplyReader;
import org.api.beacon.reply.infrastructure.ReplyRepository;
import org.api.beacon.reply.interfaces.ReplyResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyReader replyReader; // DDD CQRS
    private final ReplyStore replyStore; // DDD CQRS

    public ReplyServiceImpl(ReplyRepository replyRepository, ReplyReader replyReader, ReplyStore replyStore) {
        this.replyRepository = replyRepository;
        this.replyReader = replyReader;
        this.replyStore = replyStore;
    }

    @Override
    public ReplyResponseDto retrieveReply(Long replyId) {
        var reply = replyReader.getReplyById(replyId);
        return new ReplyResponseDto(reply);
    }

    @Override
    public List<Reply> retrieveAllReply(Long studyId) {
        List<Reply> list = replyReader.getReplyAllById(studyId);
        return list;
    }

    @Override
    public void createReply(Reply reply) {
        replyStore.saveReply(reply);
    }

    @Override
    public Reply updateReply(Long id, Reply reply) {

        Reply replyOrigin = replyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("업데이트할 ID 의 스터디가 없습니다 : "+id));

        replyOrigin.updateReply(reply.getReplyDetail(), reply.getUpdId(), reply.getUpdDt());

        Reply updateReply = replyStore.updateReply(id, replyOrigin);

        return updateReply;
    }
}
