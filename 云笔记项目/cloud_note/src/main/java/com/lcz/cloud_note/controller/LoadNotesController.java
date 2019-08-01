package com.lcz.cloud_note.controller;

import com.lcz.cloud_note.service.NoteService;
import com.lcz.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/note")//匹配路径
public class LoadNotesController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping(value = "/loadNotes.do")
	@ResponseBody//以json格式返回
	public NoteResult<List<Map>> execute(String bookName){
		System.out.println(bookName);
		NoteResult<List<Map>> result = noteService.loadBookNotes(bookName);
		return result;
	}
}
