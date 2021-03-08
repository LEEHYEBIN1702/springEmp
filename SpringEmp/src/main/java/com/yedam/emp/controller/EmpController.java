package com.yedam.emp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;

@Controller
public class EmpController {
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	@GetMapping("/insertEmp") //등록페이지로
	public String insertEmp(EmpVO vo, Model model, DeptVO deptVO, JobVO jobVO) {   //페이지로 가는 건 get
//		deptVO.setStart(1);
//		deptVO.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(deptVO));
//		model.addAttribute("jobList", jobService.getSearchJob(jobVO));
		return "/emp/insertEmp";	
	}
	@PostMapping("/insertEmp") //등록처리
	public String insertEmpProc(@Valid EmpVO vo, BindingResult result, DeptVO deptVO, Model model) { //처리는 post 다르게 주어서 구분을 한다. 자동으로 파라미터도 넘겨줌
		//입력값 검증
//		EmpValidation empValidation = new EmpValidation();
//		empValidation.validate(vo, result);
		if(result.hasErrors()) {
			model.addAttribute("deptList", deptService.getSearchDept(deptVO));
			return "/emp/insertEmp";
		}else {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
		}
	}
	@GetMapping("/updateEmp") //수정페이지로
	public String updateEmp(EmpVO vo, Model model, DeptVO deptVO, JobVO jobVO) {
		model.addAttribute("deptList", deptService.getSearchDept(deptVO));
		model.addAttribute("jobList", jobService.getSearchJob(jobVO));
		model.addAttribute("empVO", empService.getEmp(vo));
		return "/emp/updateEmp";	
	}
	@PostMapping("/updateEmp") //수정처리
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";	
	}
	@RequestMapping("/deleteEmp") //삭제   //get post 뭐 적어야 할지 헷갈리면 RequestMapping
	public String deleteEmp(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:/getSearchEmp";	
	}
	@GetMapping("/getEmp") //단건조회 // /{employee_id}
	public String getEmp( Model model
//			            , HttpServletRequest request
//			            ,@RequestParam(value ="id"
//			            , required = false
//			            , defaultValue = "100") String employee_id
//			            ,@PathVariable String employee_id
			            ,@ModelAttribute("employee") EmpVO vo
			            ) {
		//1.get Parameter (예전방식)
		/*
		 * String employee_id = request.getParameter("employee_id");
		 * if (employee_id == null) {
		 *     employee_id == "100";
		 * }
		 */
		//EmpVO vo = new EmpVO();
		//vo.setEmployee_id(employee_id);
		
		model.addAttribute("emp", empService.getEmp(vo)); //넘어온 파라미터가 자동으로 EmpVO에 담기고 그 값은 자동으로 model에도 담긴다
 		return "/emp/getEmp";	
	}
	@GetMapping("/getSearchEmp") //검색조회
	public String getSearchEmp(EmpSearchVO vo, Paging paging, Model model) {
		paging.setPageUnit(5); //한 페이지에 표시되는 레코드 건수
		paging.setPageSize(3); //페이지 번호수
		//페이징
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo)); //숫자 100은 임의
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";	
	}
}
