package com.lcz.cloud_note.dao;

import com.lcz.cloud_note.entity.Book;

import java.util.List;


public interface BookDao {
	//根据登录的uid查找笔记本的数据
	public List<Book> findByUserId(String userId);
	//根据笔记本名字取得笔记本ID
	public String getBookId(String bookName);
	//增加笔记本的操作
	public void save(Book book);
}
