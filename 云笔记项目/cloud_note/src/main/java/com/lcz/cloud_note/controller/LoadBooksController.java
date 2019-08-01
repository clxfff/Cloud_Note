package com.lcz.cloud_note.controller;

import com.lcz.cloud_note.entity.Book;
import com.lcz.cloud_note.service.BookService;
import com.lcz.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class LoadBooksController {
	@Resource
	private BookService bookService;
	
	@RequestMapping(value = "/loadBooks.do")
	@ResponseBody
	public NoteResult<List<Book>> execute(String userName){
		System.out.println(userName);
		NoteResult<List<Book>> result = bookService.loadUserBook(userName);
		return result;	
	}
}
