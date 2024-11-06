package com.openlibrary.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.GetMapping;
import java.sql.SQLException;
import java.text.Annotation;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}

@Controller
class View{
	@GetMapping("/")
	public String homePage(Model model) throws SQLException{
		LibraryController controller = LibraryController.getInstance();

		model.addAttribute("userCount", controller.getUserCount());
		model.addAttribute("bookCount", controller.getBookCount());

		return "home";
	}
	@GetMapping("/books")
	public String booksPage(Model model) throws SQLException{
		LibraryController controller = LibraryController.getInstance();

		model.addAttribute("books", controller.getBooks());

		return "books";
	}
	@PostMapping("/books")
	public String postMethodName(@RequestParam String title,
								 @RequestParam String author,
								 @RequestParam String description,
								 @RequestParam String link,
								 @RequestParam int year) throws SQLException {
		LibraryController controller = LibraryController.getInstance();
		System.out.println(author);
		
		controller.addBook(new Book.BookBuilder().setTitle(title).setAuthor(author).setDescription(description).setImgLink(link).setYear(year).build());
		return "redirect:/books";
	}
	
}