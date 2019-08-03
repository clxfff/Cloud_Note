package com.lcz.cloud_note.controller;

import com.lcz.cloud_note.service.NoteService;
import com.lcz.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteName,String body){
		System.out.println(noteName+","+body);
		NoteResult<Object> result = noteService.updateNote(noteName, body);
		return result;
	}

	@RequestMapping("/updateNoteTitle.do")
	@ResponseBody
	public NoteResult<Object> updateNoteTitle(String noteName,String title){
		System.out.println(noteName+","+title);
		NoteResult<Object> result = noteService.updateNoteTitle(noteName,title);
		return result;
	}
}
