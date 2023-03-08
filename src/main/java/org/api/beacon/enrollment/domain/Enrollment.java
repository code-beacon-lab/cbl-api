package org.api.beacon.enrollment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.api.beacon.member.domain.Member;
import org.api.beacon.study.domain.Study;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ENROLLMENT")
@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Member member;

    @NotNull
    @ManyToOne
    private Study study;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    public static Enrollment createEnrollment(Member requestMember, Study requestStudy) {
        return Enrollment.builder()
                .member(requestMember)
                .study(requestStudy)
                .status(EnrollmentStatus.PENDING)
                .build();
    }
}