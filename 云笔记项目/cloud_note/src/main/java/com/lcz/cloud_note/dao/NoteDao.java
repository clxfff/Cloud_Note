package com.lcz.cloud_note.dao;

import com.lcz.cloud_note.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteDao {
	//根据点击的bookId，从而返回一个笔记本中的笔记
	public List<Map> findByBookId(String bookId);
	
	//单击笔记,加载笔记相关信息
	public Note findByNoteId(String noteId);

	public Note findByNoteName(String noteName);

	//更新笔记信息（保存笔记）事件
	public int updateNote(Note note);
	public int updateNoteTitle(Note note);
	//增加笔记事件
	public void save(Note note);
	public int delNote(String noteId);
	public int delAllNote(String bookId);
	//删除(及移动)笔记事件（即动态的更新笔记的状态id为删除状态）
	public int dynamicUpdate(Note note);
}
