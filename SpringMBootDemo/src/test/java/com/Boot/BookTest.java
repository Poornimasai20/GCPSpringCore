package com.Boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Boot.Model.Book;
import com.Boot.Repo.BookRepo;
import com.Boot.Service.BookService;
@SpringBootTest
public class BookTest {
    @MockBean
	private BookRepo repository;
    @Autowired
    private BookService service;
    
    @Test
    public void getAllBook()

    {
    	when(repository.findAll()).thenReturn(Stream.of(new Book(19,"Java","Gosling"),new Book(20,"Python","dert")).
    			collect(Collectors.toList()));
    	assertEquals(2, service.getAllBook().size());
    }
	
	  @Test
	  public void fetchById()
	  {
		  int id=21;
		  Optional <Book> b=Optional.ofNullable(new Book(21,"javaScript","wasemm"));
		  when(repository.findById(id)).thenReturn(Optional.ofNullable(new Book(21,"javascript","waseem")));
		  assertEquals(b.get().getId(),service.fetchBookByID(id).get().getId());
	  }
	  @Test
	  public void getBookByName() { 
		  String name="c++"; 
		  when(repository.findByName(name)).thenReturn( Stream.of(new Book(21,"c++","abcd"),
				  new Book(22,"Ruby","khdj")).
	  collect(Collectors.toList())); 
	  }
		
		  @Test 
		  public void saveuser() {
		   Book book=new Book(12,"Spring","Vasukimam");
		   when(repository.save(book)).thenReturn(book);
		   assertEquals(book,service.addBook(book));
		   
		  }
		 
	 
	
	
	
}
