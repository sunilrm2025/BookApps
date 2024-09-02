package in.sunilit.BooksApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.sunilit.BooksApp.service.BooKService;


@SpringBootApplication
public class BooksAppApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(BooksAppApplication.class, args);
		BooKService bean = run.getBean(BooKService.class);
		bean.getBookList();
	}
}
