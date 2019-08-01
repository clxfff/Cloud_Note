package com.lcz.cloud_note.service;

import com.lcz.cloud_note.entity.Book;
import com.lcz.cloud_note.util.NoteResult;

import java.util.List;

public interface BookService {
	//根据登录的uid查找笔记本的数据
	public NoteResult<List<Book>> loadUserBook(String userName);
	//增加笔记本名称
	public NoteResult<Book> addBook(String userId,String title);
}
