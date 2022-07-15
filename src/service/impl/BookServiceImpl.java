package service.impl;

import java.util.List;

import bean.Book;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

public class BookServiceImpl implements BookService {
	
	BookDao dao=new BookDaoImpl();
	@Override
	public List<Book> findBookAll() {
		// TODO Auto-generated method stub
		return dao.findBookAll();
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		return dao.deleteBook(id)>0?true:false;
	}

	@Override
	public boolean insertBook(Book book) {
		// TODO Auto-generated method stub
		return dao.insertBook(book)>0?true:false;
	}

}
