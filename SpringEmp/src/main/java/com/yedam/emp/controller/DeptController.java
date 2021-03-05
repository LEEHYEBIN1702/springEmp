package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;

@Controller
public class DeptController {
	@Autowired DeptService deptService;

	
	  @GetMapping("/insertDept") //등록페이지로 
	  public String insertDept(DeptVO vo) { //페이지로 가는 건 get 
		  return "/dept/insertDept"; 	 
	  }
	  
	  @PostMapping("/insertDept") //등록처리 
	  public String insertDeptProc(DeptVO vo) { //처리는 post 다르게 주어서 구분을 한다. 자동으로 파라미터도 넘겨줌 
		  return "redirect:/getSearchDept"; 
	  }

	  @GetMapping("/updateDept") //수정페이지로 
	  public String updateDept(DeptVO vo, Model model) {
		  model.addAttribute("DeptVO", deptService.getDept(vo)); 
		  return "/dept/updateDept";   
	  }
	  
	  @PostMapping("/updateDept") //수정처리 
	  public String updateDeptProc(DeptVO vo) {
	      deptService.updateDept(vo); 
          return "redirect:/getSearchDept"; 
      }
	  
	  @RequestMapping("/deleteDept") //삭제 //get post 뭐 적어야 할지 헷갈리면 RequestMapping
	  public String deleteDept(DeptVO vo) { 
		  deptService.deleteDept(vo); 
		  return "redirect:/getSearchDept"; 
	 }
	  
	  @GetMapping("/getDept") //단건조회 
	  public String getDept(DeptVO vo, Model model) { 
	      model.addAttribute("dept", deptService.getDept(vo)); 
	      return"/dept/getDept";
	 }
	
	@GetMapping("/getSearchDept") //검색조회
	public String getSearchDept(DeptVO vo, Paging paging, Model model) {
		paging.setPageUnit(5); //한 페이지에 표시되는 레코드 건수
		paging.setPageSize(3); //페이지 번호수
		//페이징
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(deptService.getCount(vo)); //숫자 100은 임의
		model.addAttribute("paging", paging);
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "/dept/getSearchDept";	
	}
}
