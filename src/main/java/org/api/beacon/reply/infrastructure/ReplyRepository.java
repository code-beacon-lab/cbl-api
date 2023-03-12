package org.api.beacon.reply.infrastructure;

import org.api.beacon.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // 댓글 찾기
    Optional<Reply> findById(Long replyId);

    // 게시물에 대한 댓글 전체 조회
    List<Reply> findAllByStudyId(Long studyId);
}
