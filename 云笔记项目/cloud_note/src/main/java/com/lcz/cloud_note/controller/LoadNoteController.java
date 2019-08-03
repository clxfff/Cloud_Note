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
public class LoadNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/loadNote.do")
	@ResponseBody//以json格式返回数据
	public NoteResult<Note> execute(String noteName){
		System.out.println(noteName);
		NoteResult<Note> result = noteService.loadNote(noteName);
		return result;
	}
}
