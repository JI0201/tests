package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import dao.BookDao;
import utils.BaseDao;

public class BookDaoImpl extends BaseDao implements BookDao{

	@Override
	public List<Book> findBookAll() {
		String sql="select * from bookmanage";
		List<Book> list=new ArrayList<Book>();
		Book book=null;
		resultSet=findObject(sql, null);
		try {
			while(resultSet.next()) {
				book=new Book(resultSet.getInt("id"),
							  resultSet.getString("name"),
							  resultSet.getString("author"),
							  resultSet.getString("time"),
							  resultSet.getInt("type"));
				list.add(book);
			}
			return list;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(resultSet,preparedStatement,connection);
		}
		return null;
	}

	@Override
	public int deleteBook(int id) {
		String sql="delete from bookmanage where id=?";
		return updateObject(sql, id);
	}

	@Override
	public int insertBook(Book book) {
		String sql="insert into bookmanage value(null,?,?,?,?)";
		return updateObject(sql, book.getName(),book.getAuthor(),book.getTime(),book.getType());
	}

	
}
