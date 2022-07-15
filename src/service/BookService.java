package service;

import java.util.List;

import bean.Book;

public interface BookService {
		
	
		//查询所有书籍
		List<Book> findBookAll();
		//根据id删除书籍
		boolean deleteBook(int id);
		//添加书籍
		boolean insertBook(Book book);
}
