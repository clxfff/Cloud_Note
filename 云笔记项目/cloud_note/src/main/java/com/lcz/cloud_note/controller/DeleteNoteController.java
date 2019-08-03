package com.lcz.cloud_note.controller;

import com.lcz.cloud_note.service.NoteService;
import com.lcz.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult execute(String noteName){
		NoteResult result=noteService.deleteNote(noteName);
		return result;
	}
}
