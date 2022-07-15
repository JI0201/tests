package test;


import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import bean.Book;
import service.BookService;
import service.impl.BookServiceImpl;


class Test2 {
	BookService service=new BookServiceImpl();
	
	//添加
	@Test
	void test01() {
		
	
		
	}
	//删除
	@Test
	void test02() {
		boolean result=service.deleteBook(5);
		System.out.println(result);
	}
	//查询
	@Test
	public void test03() {
		List<Book> list=service.findBookAll();
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
