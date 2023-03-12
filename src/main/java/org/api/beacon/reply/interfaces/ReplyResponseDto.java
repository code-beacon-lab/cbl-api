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
    private String replyDetail;
    private String crtId;
    private String crtDt;
    private String updId;
    private String updDt;
    public ReplyResponseDto(Reply reply) {
        this.id = reply.getId();
        this.replyDetail = reply.getReplyDetail();
        this.crtId = reply.getCrtId();
        this.crtDt = reply.getCrtDt();
        this.updId = reply.getUpdId();
        this.updDt = reply.getUpdDt();
    }

}
