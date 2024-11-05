package com.openlibrary.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;


@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}

@RestController
class View{
	@GetMapping("/users")
	public String homePage() throws SQLException{
		Controller controller = Controller.getInstance();

		int userCount = controller.getUserCount();

		String returnString = "Found " + userCount + " users in the database\n<table> <tr> <th>ID</th> <th>First Name</th> <th>Last Name</th> <th>Email</th> <th>Administrator</th> </tr>";
		for(int i = 0; i < userCount; ++i){

		}
		returnString += "</table>";
		return returnString;
	}
}