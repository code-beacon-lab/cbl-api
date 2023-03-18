package org.api.beacon.enrollment.application;

import java.util.List;

import org.api.beacon.enrollment.domain.Enrollment;
import org.api.beacon.enrollment.interfaces.EnrollRequestDto;
import org.api.beacon.enrollment.interfaces.EnrollResponseDto;

public interface EnrollmentService {

	//List<EnrollRequestDto> findAll();
	List<Enrollment> findAll();
	

	
}
