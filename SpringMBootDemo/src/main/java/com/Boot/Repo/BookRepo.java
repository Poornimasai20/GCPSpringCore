package com.Boot.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Boot.Model.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
 public List<Book> findByName(String name);

}