package org.api.beacon.enrollment.application.impl;


import java.util.ArrayList;
import java.util.List;

import org.api.beacon.enrollment.application.EnrollmentService;
import org.api.beacon.enrollment.domain.Enrollment;
import org.api.beacon.enrollment.infrastructure.EnrollmentRepository;
import org.api.beacon.enrollment.interfaces.EnrollRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EnrollmentServiceImpl implements EnrollmentService{

	private final EnrollmentRepository enrollmentRepository;
	
//	@Override
//	@Transactional
//	public List<EnrollRequestDto> getEnrollmentList() {
//		List<Enrollment> enrollments = enrollmentRepository.findAll();
//		List<EnrollRequestDto> enrollmentList = new ArrayList<>();
//		
//		for(Enrollment enrollment : enrollments) {
//			EnrollRequestDto enrollmentDto = EnrollRequestDto.builder()
//					.memberId(enrollment.getMemberId())
//					.studyId(enrollment.getStudyId())
//					.status(enrollment.getStatus())
//					.build();
//			
//		}
//		return enrollmentList;  
//	}
	
	@Override
	@Transactional
	public List<Enrollment> findAll(){
		return enrollmentRepository.findAll();
	}
}
