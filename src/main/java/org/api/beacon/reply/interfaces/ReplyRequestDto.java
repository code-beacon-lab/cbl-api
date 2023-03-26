package org.api.beacon.reply.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ReplyRequestDto {
    private Long id;
    private String memberEmail;
    private Long studyId;
    private String replyDetail;
    private String crtId;
    private String crtDt;
    private String updId;
    private String updDt;

}
