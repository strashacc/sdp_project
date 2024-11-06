package com.openlibrary.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.openlibrary.Controller.*;
import com.openlibrary.Model.*;


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
	@PostMapping("/books/external")
	public String addExternalBook(@RequestParam int uniqueCode,
                              @RequestParam String bookName,
                              @RequestParam String bookAuthor,
                              @RequestParam String imgLink,
                              Model model) {

    	ExternalBook externalBook = new ExternalBook(uniqueCode, bookName, bookAuthor, imgLink);
    	LibraryFacade facade = new LibraryFacade();
    	facade.addExternalBook(externalBook);

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
