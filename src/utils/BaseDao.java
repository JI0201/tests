package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	
	public Connection connection;
	public ResultSet resultSet;
	public PreparedStatement preparedStatement;
	
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//创建链接
	public Connection getConnection() {
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//关闭连接
	public void closeAll(AutoCloseable ...autoCloseables) {
		
				try {
					for(int i=0;i<autoCloseables.length;i++) {
						if(autoCloseables[i]!=null) {
					autoCloseables[i].close();
						} 
					}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	//增删改
	public int updateObject(String sql,Object ...objects) {
			connection=getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				if(objects!=null) {
					for(int i=0;i<objects.length;i++) {
						preparedStatement.setObject(i+1, objects[i]);
					}
				}
				int result=preparedStatement.executeUpdate();
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeAll(preparedStatement,connection);
			}
			return 0;
			
	}
	
	
	//查询
	public ResultSet findObject(String sql,Object ...objects) {
		connection=getConnection();
		try {
			preparedStatement=connection.prepareStatement(sql);
			if(objects!=null) {
				for(int i=0; i<objects.length;i++) {
					preparedStatement.setObject(i+1, objects[i]);
				}
			}
			resultSet=preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
