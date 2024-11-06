package com.openlibrary.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.text.Annotation;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openlibrary.Controller.*;


@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}

@Controller
class View{
	@GetMapping("/books")
	public String booksPage(Model model) {
		LibraryFacade facade = new LibraryFacade();

		model.addAttribute("books", facade.getBooks());

		return "books";
	}
	@PostMapping("/books")
	public String postMethodName(@RequestParam String title
								,@RequestParam String author
								,@RequestParam String type
								,@RequestParam String link
								, Model model) {

		LibraryFacade facade = new LibraryFacade();
		facade.addBook(type, title, author, link);

		model.addAttribute("books", facade.getBooks());
		
		return "books";
	}
	
	@GetMapping("/books/delete/{id}")
	public String getMethodName(@PathVariable int id) {
		LibraryFacade facade = new LibraryFacade();
		facade.removeBook(id);
		return "redirect:/books";
	}
	
}