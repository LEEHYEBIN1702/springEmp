package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Controller
public class JobController {
	@Autowired JobService jobService;
	
	 @GetMapping("/insertJob") //등록페이지로 
	  public String insertJob(JobVO vo) { //페이지로 가는 건 get 
		  return "/job/insertJob"; 	 
	  }
	  
	  @PostMapping("/insertJob") //등록처리 
	  public String insertJobProc(JobVO vo) { //처리는 post 다르게 주어서 구분을 한다. 자동으로 파라미터도 넘겨줌 
		  return "redirect:/getSearchJob"; 
	  }

	  @GetMapping("/updateJob") //수정페이지로 
	  public String updateJob(JobVO vo, Model model) {
		  model.addAttribute("JobVO", jobService.getJob(vo)); 
		  return "/job/updateJob";   
	  }
	  
	  @PostMapping("/updateJob") //수정처리 
	  public String updateJobProc(JobVO vo) {
	      jobService.updateJob(vo); 
         return "redirect:/getSearchJob"; 
     }
	  
	  @RequestMapping("/deleteJob") //삭제 //get post 뭐 적어야 할지 헷갈리면 RequestMapping
	  public String deleteJob(JobVO vo) { 
		  jobService.deleteJob(vo); 
		  return "redirect:/getSearchJob"; 
	 }
	  
	  @GetMapping("/getJob") //단건조회 
	  public String getJob(JobVO vo, Model model) { 
	      model.addAttribute("job", jobService.getJob(vo)); 
	      return"/job/getJob";
	 }
	
	@GetMapping("/getSearchJob") //검색조회
	public String getSearchJob(JobVO vo, Model model) {
		model.addAttribute("list", jobService.getSearchJob(vo));
		return "/job/getSearchJob";	
	}

}
