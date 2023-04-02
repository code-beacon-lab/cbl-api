package org.api.beacon.reply.domain;

import lombok.*;
import org.api.beacon.reply.interfaces.ReplyRequestDto;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


/*
* @Title : 댓글 엔터티
* @Writer : seonguk092
* */

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Entity(name = "TB_REPLY")
@DynamicInsert // DDL 유지를 위해 추가(Default값 적용시 사용해야함)
public class Reply {

    // 댓글 아이디(PK, AI)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    // 회원 이메일(FK, PK)
    @Column(name = "member_email")
    private String memberEmail;

    // 스터디 아이디(FK, PK)
    @Column(name = "study_id")
    private Long studyId;

    // 댓글 내용
    @Column(name = "reply_detail")
    private String replyDetail;

    // 댓글 내용
    @Column(name = "reply_state")
    @ColumnDefault("true") // true : 활성화, false : 삭제 처리
    private Boolean replyState;

    // 작성자 아이디
    @Column(name = "crt_id")
    private String crtId;

    // 작성일
    @Column(name = "crt_dt")
    private String crtDt;

    // 수정자 아이디
    @Column(name = "upd_id")
    private String updId;

    // 수정일
    @Column(name = "upd_dt")
    private String updDt;

    public static Reply createReply(ReplyRequestDto replyRequestDto) {
        return Reply.builder()
                .memberEmail(replyRequestDto.getMemberEmail())
                .studyId(replyRequestDto.getStudyId())
                .replyDetail(replyRequestDto.getReplyDetail())
                .crtId(replyRequestDto.getCrtId())
                .crtDt(replyRequestDto.getCrtDt())
                .updId(replyRequestDto.getUpdId())
                .updDt(replyRequestDto.getUpdDt())
                .build();
    }

    public void updateReply(ReplyRequestDto replyRequestDto) {
        this.replyDetail = replyRequestDto.getReplyDetail();
        this.updId = replyRequestDto.getUpdId();
        this.updDt = replyRequestDto.getUpdDt();
    }


    public void deleteReply(ReplyRequestDto replyRequestDto) {
        this.replyState = false;
        this.updId = replyRequestDto.getUpdId();
        this.updDt = replyRequestDto.getUpdDt();
    }
}
