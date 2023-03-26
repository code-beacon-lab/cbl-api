package org.api.beacon.enrollment.domain;

import org.api.beacon.member.domain.Member;
import org.api.beacon.study.domain.Study;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EnrollmentTest {
//    private Member joinedMember;

//    @BeforeAll
//    void setting() {
//
//    }

    // 기본 상태는 신청 대기
    @Test void newEnrollment() {
        // given
        Member requestMember = new Member();
        Study requestStudy = new Study();

        // when
        Enrollment enrollment = Enrollment.createEnrollment(requestMember, requestStudy);

        // then
        assertThat(enrollment.getStatus()).isEqualTo(EnrollmentStatus.PENDING);
    }


    // 같은 회원은 같은 스터디에 중복 신청할 수 없음 -> 회원 도메인 완성 후

//    @Test -> 스터디 도메인 완성 후
//    void 없는_스터디는_신청할_수_없음() {
//        Enrollment.builder()
//                .member()
//
//    }

}