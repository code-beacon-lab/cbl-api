package org.api.beacon.reply.infrastructure.reader;

import org.api.beacon.reply.domain.Reply;
import org.api.beacon.reply.domain.ReplyReader;
import org.api.beacon.reply.infrastructure.ReplyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReplyReaderImpl implements ReplyReader {

    private final ReplyRepository replyRepository;

    public ReplyReaderImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public Reply getReplyById(Long replyId) {
        return replyRepository.findById(replyId).orElseThrow(IllegalStateException::new); // TODO 공통 예외 클래스로 처리
    }

    @Override
    public List<Reply> getReplyAllByStudyId(Long studyId) {
        return replyRepository.findAllByStudyId(studyId);
    }
}
