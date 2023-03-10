package org.api.beacon.reply.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.api.beacon.reply.domain.Reply;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ReplyResponseDto {
    private Long id;
    private String crtId;
    private String replyDetail;
    public ReplyResponseDto(Reply reply) {
        this.id = reply.getId();
        this.crtId = reply.getCrtId();
        this.replyDetail = reply.getReplyDetail();
    }

}
