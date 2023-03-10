package org.api.beacon.reply.domain;

import lombok.*;

import javax.persistence.*;


/*
* @Title : 댓글 엔터티
* @Writer : seonguk092
* */
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "TB_REPLY")
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

    @Builder(builderMethodName = "createBuilder")
    public void Reply(Long id, String memberEmail, Long studyId, String replyDetail, String crtId, String crtDt, String updId, String updDt) {
        this.id = id;
        this.memberEmail = memberEmail;
        this.studyId = studyId;
        this.replyDetail = replyDetail;
        this.crtId = crtId;
        this.crtDt = crtDt;
        this.updId = updId;
        this.updDt = updDt;
    }

    @Builder(builderMethodName = "updateBuilder")
    public void updateReply(String replyDetail, String updId, String updDt) {
        this.replyDetail = replyDetail;
        this.updId = updId;
        this.updDt = updDt;
    }
}
