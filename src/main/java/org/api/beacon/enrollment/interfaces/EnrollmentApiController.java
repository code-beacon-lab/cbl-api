package org.api.beacon.enrollment.interfaces;

import java.util.List;

import org.api.beacon.enrollment.application.EnrollmentService;
import org.api.beacon.enrollment.domain.Enrollment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/api/enrollment")
@RestController
@RequiredArgsConstructor
public class EnrollmentApiController {
	
	private final EnrollmentService enrollmentService;
	
	//스터디 가입이력조회
//	@GetMapping
//	public String findAllByEnrollmentList(Model model) {
//		List<EnrollRequestDto> enrollRequestList = enrollmentService.getEnrollmentList();
//		model.addAttribute("enrollmentList", enrollRequestList);
//		return "enrollmentList";
//	}
	

	@GetMapping
	public List<Enrollment> findAll(){
		return (List<Enrollment>) enrollmentService.findAll();
	}
}