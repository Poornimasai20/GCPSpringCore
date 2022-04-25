package com.Boot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Boot.Model.Book;
import com.Boot.Repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookrepo;
	
	
	public Book addBook(Book bookobj)
	{
		return bookrepo.save(bookobj);
	}
	public List<Book> getAllBook()
	{
		return  bookrepo.findAll();
	}
	public Optional<Book> fetchBookByID(int id)
	{
		return bookrepo.findById(id);
	}
	public Book updateBookId(Book bookobj)
	{
		return bookrepo.save(bookobj);	
	}

	
	  public List<Book> findByName(String name) { 
		  List<Book> b= bookrepo.findByName(name); 
	       return b;
	  }
}

