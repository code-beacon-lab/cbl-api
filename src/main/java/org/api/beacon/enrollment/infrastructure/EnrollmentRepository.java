package org.api.beacon.enrollment.infrastructure;


import java.util.List;

import org.api.beacon.enrollment.domain.Enrollment;
import org.api.beacon.enrollment.interfaces.EnrollRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,String>{
	List<Enrollment> findAll();
	
}
