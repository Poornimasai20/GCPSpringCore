package com.Boot.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Book {
	@Id
	private int id;
	@NotBlank
	@Size(min = 2, message = "name length should be min of 2")
	private String name;
	@NotBlank
	@Size(min = 3, message = "authorname length should be min of 3")
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "BookModel [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
}
