package org.api.beacon.reply.application.impl;

import org.api.beacon.reply.application.ReplyService;
import org.api.beacon.reply.domain.Reply;
import org.api.beacon.reply.domain.ReplyReader;
import org.api.beacon.reply.domain.ReplyStore;
import org.api.beacon.reply.infrastructure.ReplyRepository;
import org.api.beacon.reply.interfaces.ReplyRequestDto;
import org.api.beacon.reply.interfaces.ReplyResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(readOnly = true) // readOnly true시 변경 감지 스냅샷을 유지 않아도 되어 메모리 절약 가능
    public List<Reply> retrieveAllReply(Long studyId) {
        return replyReader.getReplyAllByStudyId(studyId);
    }

    @Override
    @Transactional
    public Reply createReply(ReplyRequestDto replyRequestDto) {
        var newReply = Reply.createReply(replyRequestDto);
        return replyStore.saveReply(newReply);
    }

    @Override
    @Transactional
    public Reply updateReply(ReplyRequestDto replyRequestDto) {

        Reply replyOrigin = replyRepository.findById(replyRequestDto.getId()).orElseThrow(() -> new IllegalArgumentException("업데이트할 ID 의 스터디가 없습니다 : " + replyRequestDto.getId() ));

        replyOrigin.updateReply(replyRequestDto);

        return replyStore.updateReply(replyOrigin);
    }


    @Override
    @Transactional
    public Reply deleteReply(ReplyRequestDto replyRequestDto) {

        Reply replyOrigin = replyRepository.findById(replyRequestDto.getId()).orElseThrow(() -> new IllegalArgumentException("삭제할 ID 의 스터디가 없습니다 : " + replyRequestDto.getId() ));

        replyOrigin.deleteReply(replyRequestDto);

        return replyStore.deleteReply(replyOrigin);
    }
}
