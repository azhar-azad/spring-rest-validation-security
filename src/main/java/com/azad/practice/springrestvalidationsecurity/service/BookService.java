package com.azad.practice.springrestvalidationsecurity.service;

import java.util.List;
import java.util.Map;

import com.azad.practice.springrestvalidationsecurity.entity.BookEntity;

public interface BookService {

	BookEntity createBook(BookEntity newBook);

	List<BookEntity> getAllBooks();

	BookEntity getOneBook(Long id);

	BookEntity updateBook(Long id, BookEntity updateBookDetails);

	void deleteBook(Long id);

	BookEntity patchBook(Long id, Map<String, String> update);

}
