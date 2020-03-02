package com.azad.practice.springrestvalidationsecurity.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.springrestvalidationsecurity.entity.BookEntity;
import com.azad.practice.springrestvalidationsecurity.service.BookService;

@RestController
@RequestMapping(path = "books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // return 201 instead of 200
	public BookEntity createBook(@RequestBody BookEntity newBook) {
		
		return bookService.createBook(newBook);
	}
	
	@GetMapping
	public List<BookEntity> getAllBooks() {
		
		return bookService.getAllBooks();
	}
	
	@GetMapping(path = "/{id}")
	public BookEntity getOneBook(@PathVariable Long id) {
		
		return bookService.getOneBook(id);
	}
	
	@PutMapping(path = "/{id}")
	public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity updateBookDetails) {
		
		return bookService.updateBook(id, updateBookDetails);
	}
	
	@DeleteMapping(path = "/{id}")
	void deleteBook(@PathVariable Long id) {
		
		bookService.deleteBook(id);
	}
	
	// update Author only
	@PatchMapping(path = "/{id}")
	public BookEntity patchBook(@PathVariable Long id, @RequestBody Map<String, String> update) {
		return bookService.patchBook(id, update);
	}
}
