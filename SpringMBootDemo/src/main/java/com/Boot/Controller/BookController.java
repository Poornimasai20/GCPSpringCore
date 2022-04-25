package com.Boot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Boot.Exception.IdNotFoundException;
import com.Boot.Model.Book;
import com.Boot.Service.BookService;

@RestController
@RequestMapping("/Book")
public class BookController {

	@Autowired
	BookService bookservice;

	@PostMapping("/addBook")
	public ResponseEntity<String> addBookDetails(@Validated @RequestBody Book book) {
		Book bookresponse = bookservice.addBook(book);
		return new ResponseEntity<String>("has inserted successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllBook")
	public ResponseEntity<List<Book>> fetchAllBook() {
		List<Book> bookresp = bookservice.getAllBook();
		return new ResponseEntity<List<Book>>(bookresp, HttpStatus.OK);

	}

	@GetMapping("/getBookById")
	public ResponseEntity<Book> fetchBookById(@RequestParam("id") int id) {
		Optional<Book> book = bookservice.fetchBookByID(id);
		return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
	}
		@PutMapping("/updateBookById")
		public ResponseEntity<String> updateBookById(@RequestBody Book book)
		{
			String status=null;
			Optional<Book> obj=bookservice.fetchBookByID(book.getId());
			if(obj.isPresent())
			{
				bookservice.updateBookId(book);
				status="Successfully updated";
			}
			
			  else { 
				 
				  throw new IdNotFoundException("Given id its not available in database"); }
			 
			return new ResponseEntity<String>(status, HttpStatus.OK);
			
		}
	}

