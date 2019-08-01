package com.lcz.cloud_note.controller;

import com.lcz.cloud_note.entity.Book;
import com.lcz.cloud_note.service.BookService;
import com.lcz.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class AddBookController {
	@Resource
	private BookService bookService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Book> execute(String userName,String title){
		System.out.println(userName+","+title);
		NoteResult<Book> result = bookService.addBook(userName, title);
		return result;
	}
}
