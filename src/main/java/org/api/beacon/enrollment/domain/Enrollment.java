package org.api.beacon.enrollment.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.api.beacon.member.domain.Member;
import org.api.beacon.study.domain.Study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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