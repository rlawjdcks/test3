package com.maximum.koreaartschool._sb0408.controller;


import com.maximum.koreaartschool._sb0408.spring.MemberListService;
import com.maximum.koreaartschool._sb0408.spring.MemberRegisterService;
import com.maximum.koreaartschool._sb0408.spring.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private MemberRegisterService memberRegisterService;

	@Autowired
	private MemberListService memberListService;

	@RequestMapping("/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}


	@GetMapping("/list")
	public String showMemList(Model model) {
		model.addAttribute("list", memberListService.getMemberList());
		return "register/memberList";
	}

	@ModelAttribute
	public void case1(Model model) {
		model.addAttribute("value1", "안녕하세요?");
	}

	@ModelAttribute("value2")
	public String case2() {
		return "반갑습니다.";
	}

}
