package com.mypack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mypack.entity.User;
import com.mypack.services.UserServices;
import com.mypack.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserServices userServices;
	
	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
	@Autowired
	private UserValidator userValidator;
	
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doLogin(@ModelAttribute("user") User user,Model model,HttpSession session) {
		System.out.println("email="+user.getEmail());
		List<User> ulist= userServices.login(user.getEmail(), user.getPassword());
		System.out.println("ulist==="+ulist.size());
		model.addAttribute("msg", "");
		if(ulist.size() >0) {
			model.addAttribute("msg", "success");
			session.setAttribute("user", user);
			 return "redirect:/viewUsers";
		}else {
			model.addAttribute("msg", "You are entered wrong email or password.");
		}
		return null;
	}
	@RequestMapping(value="/registeration",method=RequestMethod.GET)
	public ModelAndView register(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("registeration");
		return model;
	}
	
	
	
	@RequestMapping(value="/registeration",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Validated User user, BindingResult result,Model model) {
		ModelAndView mav=new ModelAndView();
		userValidator.validate(user, result);
		System.out.println("error=="+result.hasErrors());
		if (result.hasErrors()) {
			mav.setViewName("registeration");
			mav.addObject("user",user);
	      }else {
			if (user.getId() == 0) { // if employee id is 0 then creating the
				// employee other updating the employee
				userServices.save(user);
				//mav.setViewName("viewUsers");
				return new ModelAndView("redirect:/viewUsers");
			} else {
				userServices.updateUser(user);
				return new ModelAndView("redirect:/viewUsers");
		}
		
	     }
		
		 return mav;
	}
	@RequestMapping(value="/viewUsers",method=RequestMethod.GET)
	public ModelAndView getAllUser(HttpSession session ) {
		User user = (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		if(user != null) {
			
			List<User> ulist = userServices.getAllUsers();
			if(ulist.size() >0){
				mv.addObject("users", ulist);
			}
			mv.setViewName("viewUsers");
		}else {
			return new ModelAndView("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value="/editUser",method=RequestMethod.GET)
	public ModelAndView getUserById(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("id=="+userId);
		User user = userServices.getUserById(userId);
		System.out.println("user===="+user.getId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registeration");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public ModelAndView deleterUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		userServices.delete(id);
		return new ModelAndView("redirect:/viewUsers");
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session ) {
       session.invalidate();
       return "redirect:login";
    }
}
