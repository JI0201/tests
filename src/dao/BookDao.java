package dao;

import java.util.List;

import bean.Book;

public interface BookDao {

	//查询所有书籍
	List<Book> findBookAll();
	//根据id删除书籍
	int deleteBook(int id);
	//添加书籍
	int insertBook(Book book);
	
}
