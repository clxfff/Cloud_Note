package com.lcz.cloud_note.service;

import com.lcz.cloud_note.entity.Note;
import com.lcz.cloud_note.util.NoteResult;

import java.util.List;
import java.util.Map;

public interface NoteService {
	//根据点击的bookId，从而返回一个笔记本中的笔记
	public NoteResult<List<Map>> loadBookNotes(String bookName);
	//单击笔记,加载笔记相关信息
	public NoteResult<Note> loadNote(String noteName);
	//更新笔记信息（保存笔记）事件
	public NoteResult<Object> updateNote(String noteName,String body);
	public NoteResult<Object> updateNoteTitle(String noteName,String title);
	//增加笔记事件
	public NoteResult<Note> addNote(String userId,String bookId,String title);
	//删除笔记事件
	public NoteResult deleteNote(String notaName);
	//转移笔记事件
	public NoteResult moveNote(String noteId, String bookId);
}
