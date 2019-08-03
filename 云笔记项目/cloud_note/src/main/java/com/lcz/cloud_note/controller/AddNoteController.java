package com.lcz.cloud_note.controller;

import com.lcz.cloud_note.entity.Note;
import com.lcz.cloud_note.service.NoteService;
import com.lcz.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Note> execute(String userName,String bookName,String title){
		System.out.println(userName+","+bookName+","+title);
		NoteResult<Note> result = noteService.addNote(userName, bookName, title);
		return result;
	}
}
