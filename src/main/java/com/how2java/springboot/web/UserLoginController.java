package com.how2java.springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.how2java.springboot.mapper.UserMapper;
import com.how2java.springboot.pojo.User;

@Controller
public class UserLoginController {
	@Autowired UserMapper userMapper;

	@RequestMapping("/login")
	public String userLogin(Model model){
		return "login";
	}
	
	@RequestMapping("/checkName")
	@ResponseBody
	public String checkName(Model model,User user){
		User result = userMapper.nameCheck(user);
		if(result!=null){
			return "用户名已存在";
		}
		else{
			return "可以注册";
		}
	}
	
	@RequestMapping("/registSuccess")
	public String userMainPage(User user){
		userMapper.addUser(user);
		return "login";
	}
	
	@RequestMapping("/regist")
	public String userRegist(Model mode,User user){
		return "regist";	
	}
	
	@RequestMapping("/loginSuccess")
	public String mainPage(Model model,User user,HttpServletRequest request)throws Exception{
		if(userMapper.loginCheck(user) != null){
			request.getSession().setAttribute("user", user.getUsername());
			return "mainPage";
		}
		else {
			model.addAttribute("errorMsg","登录失败，用户名或者密码错误");
			return "login";
		}
	}
}
