package com.lcz.cloud_note.controller;

import com.lcz.cloud_note.service.UserService;
import com.lcz.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class ChangeUserController {
	@Resource
	private UserService userService;
	@RequestMapping("/change.do")
	@ResponseBody
	public NoteResult<Object> execute(String userName,String last_password,String final_password){
		NoteResult<Object> result = userService.changeUser(userName, last_password, final_password);
		System.out.println(userName+","+last_password+","+final_password);
		return result;
	}
}
