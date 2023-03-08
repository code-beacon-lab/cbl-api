package org.api.beacon.enrollment.domain;

public enum EnrollmentStatus {
    PENDING("대기중"),
    APPROVED("승인"),
    REJECTED("거절");

    EnrollmentStatus(String description) {
    }
}
