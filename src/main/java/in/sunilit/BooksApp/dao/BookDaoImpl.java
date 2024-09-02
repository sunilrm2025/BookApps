package in.sunilit.BooksApp.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import in.sunilit.BooksApp.beans.Book;

@Repository
		public class BookDaoImpl implements BooKDao {
		
		
	//		private static final String CLASS_NAME="com.mysql.cj.jdbc.Driver";
			@Value("${db_URL}")
			private  String db_URL;
			
			@Value("${USER_NAME}")
			private String USER_NAME;
			
			@Value("${PASSWORD}")
			private  String PASSWORD;
			
			Connection connection = null;
		
			@Override
			public int insertBook(Book book) {
				try {
					//Class.forName(CLASS_NAME);
					connection=DriverManager.getConnection(db_URL,USER_NAME, PASSWORD);
					PreparedStatement sts=connection.prepareStatement("INSERT INTO BOOK VALUES(?,?,?)");
					sts.setInt(1, book.getId());
					sts.setString(2,book.getName());
					sts.setDouble(3,book.getPrice());
		
					int s=	sts.executeUpdate();
					return s;
				}catch (Exception e) {
					// TODO: handle exception
				}
				return 0;
			}
		
			@Override
			public void getAllBook() {
		
				try {
					//Class.forName(CLASS_NAME);
					connection=DriverManager.getConnection(db_URL,
							USER_NAME, PASSWORD);
					Statement statement;
					statement = connection.createStatement();
					ResultSet resultSet;
					resultSet = statement.executeQuery(
							"select * from book");
					String name;
					Integer id;
					Double price;
		
					while (resultSet.next()) {
		
						id = resultSet.getInt("id");
						name = resultSet.getString("bName").trim();
						price = resultSet.getDouble("bprice");
		
						System.out.println("id : " + id
								+ " name : " + name+ " price : " + price);
					}
					resultSet.close();
					statement.close();
					connection.close();
				}catch (Exception exception) {
					System.out.println(exception);
				}
			}
		
			@Override
			public void deleteRecordByPrice() {
		
				try {
					//Class.forName(CLASS_NAME);
					connection=DriverManager.getConnection(db_URL,USER_NAME, PASSWORD);
					PreparedStatement sts=connection.prepareStatement("DELETE FROM Book WHERE bPrice='6009.0'");
		
					sts.executeUpdate();
					//DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';
					// TODO Auto-generated method stub
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		
			@Override
			public void deleteRecordById() {
				try {
					//Class.forName(CLASS_NAME);
					connection=DriverManager.getConnection(db_URL,USER_NAME, PASSWORD);
					PreparedStatement sts=connection.prepareStatement("DELETE FROM Book WHERE id='103'");
		
					sts.executeUpdate();
					//DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';
					// TODO Auto-generated method stub
				}catch (Exception e) {
					// TODO: handle exception
				}
		
			}
		
			@Override
			public void deleteRecordByName() {
				try {
				//	Class.forName(CLASS_NAME);
					connection=DriverManager.getConnection(db_URL,USER_NAME, PASSWORD);
					PreparedStatement sts=connection.prepareStatement("DELETE FROM Book WHERE bname='Java'");
		
					sts.executeUpdate();
					//DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';
					// TODO Auto-generated method stub
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		
}
