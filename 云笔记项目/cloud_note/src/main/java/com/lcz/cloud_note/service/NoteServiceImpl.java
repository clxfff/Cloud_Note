package com.lcz.cloud_note.service;

import com.lcz.cloud_note.dao.BookDao;
import com.lcz.cloud_note.dao.NoteDao;
import com.lcz.cloud_note.dao.ShareDao;
import com.lcz.cloud_note.dao.UserDao;
import com.lcz.cloud_note.entity.Note;
import com.lcz.cloud_note.entity.User;
import com.lcz.cloud_note.util.NoteResult;
import com.lcz.cloud_note.util.NoteUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("noteService")//扫描到spring容器里面
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteDao noteDao;
	@Resource ShareDao shareDao;
	@Resource
	BookDao bookDao;
	@Resource
	UserDao userDao;
	
	public NoteResult<List<Map>> loadBookNotes(String bookName) {

		String bookId = bookDao.getBookId(bookName);
		//返回数据集合
		List<Map> list = noteDao.findByBookId(bookId);
		System.out.println(list);
		//构建result
		NoteResult<List<Map>> result=new NoteResult<List<Map>>();
		result.setStatus(0);
		result.setMsg("加载笔记成功");
		result.setData(list);
		return result;
	}
	
	//单击笔记,加载笔记相关信息
	public NoteResult<Note> loadNote(String noteName) {
		//返回数据集合
		Note note = noteDao.findByNoteName(noteName);
		//构建result
		NoteResult<Note> result = new NoteResult<Note>();
		if(note==null) {
			result.setMsg("未找到数据!");
			result.setStatus(1);
			return result;
		}else {
			result.setStatus(0);
			result.setMsg("加载笔记信息成功");
			result.setData(note);
			System.out.println(note);
			return result;
		}	
		
	}
	
	//更新笔记信息（保存笔记）事件
	public NoteResult<Object> updateNote(String noteName, String body) {
		String noteId = noteDao.findByNoteName(noteName).getCn_note_id();
		//创建note参数
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_body(body);
		long time = System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		//更新数据库记录
		int rows = noteDao.updateNote(note);
		//构建result
		NoteResult<Object> result = new NoteResult<Object>();
		if(rows==1) {
			result.setStatus(0);
			result.setMsg("保存笔记成功");
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("保存笔记失败");
			return result;
		}
	}
	//修改笔记标题事件
	public NoteResult<Object> updateNoteTitle(String noteName,String title){
		String noteId = noteDao.findByNoteName(noteName).getCn_note_id();
		//创建note参数
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(title);
		long time = System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		//更新数据库记录
		int rows = noteDao.updateNoteTitle(note);
		//构建result
		NoteResult<Object> result = new NoteResult<Object>();
		if(rows==1) {
			result.setStatus(0);
			result.setMsg("修改笔记标题成功");
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("修改笔记标题失败");
			return result;
		}
	}
	//增加笔记事件
	public NoteResult<Note> addNote(String userName, String bookName, String title) {

		User user = userDao.findByName(userName);
		String bookId = bookDao.getBookId(bookName);
		Note note=new Note();
		//用户ID
		note.setCn_user_id(user.getCn_user_id());
		//笔记本ID
		note.setCn_notebook_id(bookId);
		//笔记本标题
		note.setCn_note_title(title);
		//笔记Id
		String noteId=NoteUtil.createId();
		note.setCn_note_id(noteId);
		//笔记内容
		note.setCn_note_body("");
		//创建时间
		long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		//最后修改事件
		note.setCn_note_last_modify_time(time);
		//约定1-normal 2-delete
		note.setCn_note_status_id("1");
		//约定1-normal 2-favor 3-share
		note.setCn_note_type_id("1");
		noteDao.save(note);
		NoteResult<Note> result = new NoteResult<Note>();
		result.setStatus(0);
		result.setMsg("创建笔记成功");
		result.setData(note);
		return result;
	}
	//删除笔记事件
	public NoteResult deleteNote(String noteName) {
		String noteId = noteDao.findByNoteName(noteName).getCn_note_id();
		Note note = new Note();
		note.setCn_note_id(noteId);
		//更新操作
		int rows = noteDao.delNote(noteId);
		//创建返回结果
		NoteResult result = new NoteResult();
		if(rows >= 1){//成功
			result.setStatus(0);
			result.setMsg("删除笔记成功");
		}else{
			result.setStatus(1);
			result.setMsg("删除笔记失败");
		}
		return result;
	}
	//转移笔记事件
	public NoteResult<Object> moveNote(String noteId, String bookId) {
		Note note = new Note();
		note.setCn_note_id(noteId);//设置笔记ID
		note.setCn_notebook_id(bookId);//设置笔记本ID
//		int rows = 
//			noteDao.updateBookId(note);//更新
		int rows = noteDao.dynamicUpdate(note);
		//创建返回结果
		NoteResult result = new NoteResult();
		if(rows>=1){
			result.setStatus(0);
			result.setMsg("转移笔记成功");
		}else{
			result.setStatus(1);
			result.setMsg("转移笔记失败");
		}
		return result;
	}
}
