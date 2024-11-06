package com.openlibrary.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.GetMapping;
import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;


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
	
}