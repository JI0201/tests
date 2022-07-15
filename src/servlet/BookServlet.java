package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.Book;
import service.BookService;
import service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
	BookService service=new BookServiceImpl();
	
	public void findBookAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=service.findBookAll();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/pages/findBook.jsp").forward(request, response);
		}
	}
	
	
	public void deleteBook(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		boolean result=service.deleteBook(id);
		if(result) {
			findBookAll(request, response);
		}
	}
	
	
	public void insertBook(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		Book book=new Book();
		BeanUtils.populate(book, request.getParameterMap());
		boolean result=service.insertBook(book);
		if(result) {
			findBookAll(request, response);
		}
	}
	

}
