package in.sunilit.BooksApp.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sunilit.BooksApp.beans.Book;
import in.sunilit.BooksApp.dao.BooKDao;

@Service							
public class BookServiceImpl implements BooKService {

	@Autowired
	BooKDao bDao;

	@Override
	public void getBookList() {
		bDao.getAllBook();
	}
	@Override
		public void processBook() {
			String filePath="D:\\Code workspace\\BooksApp\\book.txt";
			//reading file data 11
			try {
				Stream<String>   lines=Files.lines(Paths.get(filePath));
	
				lines.forEach(line->{
	
					String[] values = line.split(",");
	
					String id = values[0];
					String name=values[1];
					String price = values[2];
	
					Book book=new Book();
	
					book.setId(Integer.parseInt(id));
					book.setName(name);
					book.setPrice(Double.parseDouble(price));
	
					int intCnt = bDao.insertBook(book);
	
					if(intCnt>0) {
	
						System.out.println("Record inserted !!!!");
					}
				});
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Override
		public void deletebookByPrice() {
	
			bDao.deleteRecordByPrice();
			// TODO Auto-generated method stub
	
		}
		@Override
		public void deletebookById() {
			bDao.deleteRecordById();		
		}
		@Override
		public void deletebookByName() {
			bDao.deleteRecordByName();		
		}
}
