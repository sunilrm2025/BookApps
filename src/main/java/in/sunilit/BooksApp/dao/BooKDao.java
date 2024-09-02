package in.sunilit.BooksApp.dao;

import in.sunilit.BooksApp.beans.Book;

public interface BooKDao{
	
	public int insertBook(Book book	);
	public void getAllBook();
	
	public void deleteRecordById();
	public void deleteRecordByName();
	public void deleteRecordByPrice();
	

}
