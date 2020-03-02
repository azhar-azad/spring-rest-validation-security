package com.azad.practice.springrestvalidationsecurity.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.azad.practice.springrestvalidationsecurity.entity.BookEntity;
import com.azad.practice.springrestvalidationsecurity.exception.BookNotFoundException;
import com.azad.practice.springrestvalidationsecurity.exception.BookUnSupportedFieldPatchException;
import com.azad.practice.springrestvalidationsecurity.repository.BookRepository;
import com.azad.practice.springrestvalidationsecurity.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookEntity createBook(BookEntity newBook) {
		return bookRepository.save(newBook);
	}

	@Override
	public List<BookEntity> getAllBooks() {
		return (List<BookEntity>) bookRepository.findAll();
	}

	@Override
	public BookEntity getOneBook(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
	}

	@Override
	public BookEntity updateBook(Long id, BookEntity updateBookDetails) {
		
		BookEntity fetchedBook = getOneBook(id);
		
		if (fetchedBook == null) {
			createBook(updateBookDetails);
		}
		
		fetchedBook.setName(updateBookDetails.getName());
		fetchedBook.setAuthor(updateBookDetails.getAuthor());
		fetchedBook.setPrice(updateBookDetails.getPrice());
		
		return bookRepository.save(fetchedBook);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public BookEntity patchBook(Long id, Map<String, String> update) {
		
		return bookRepository.findById(id).map(x -> {
			String author = update.get("author");
			if (!StringUtils.isEmpty(author)) {
				x.setAuthor(author);
				return bookRepository.save(x);
			} else {
				throw new BookUnSupportedFieldPatchException(update.keySet());
			}
		}).orElseGet(() -> {
			throw new BookNotFoundException(id);
		});
	}

}
