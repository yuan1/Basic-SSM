package cn.javayuan.controller;

import cn.javayuan.pojo.SysUser;
import cn.javayuan.service.SysUserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/sysUserController")
public class SysUserController {

	private final static Logger logger = Logger.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/showUserToJspById/{userId}")
	public String showUser(Model model,@PathVariable("userId") Long userId){
		SysUser user = this.sysUserService.getById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/showUserToJSONById/{userId}")
	@ResponseBody
	public SysUser showUser(@PathVariable("userId") Long userId){
		SysUser user = sysUserService.getById(userId);
		return user;
	}


	@RequestMapping("/test-logback")
	@ResponseBody
	public Date testLogback(){
		logger.trace("-----------------------------------trace");
		logger.debug("-----------------------------------debug");
		logger.info("-----------------------------------info");
		logger.warn("-----------------------------------warn");
		logger.error("-----------------------------------error");
		return new Date();
	}
	



}
