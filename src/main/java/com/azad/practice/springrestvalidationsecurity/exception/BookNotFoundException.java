package com.azad.practice.springrestvalidationsecurity.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8485815202244150498L;

	public BookNotFoundException(Long id) {
		super("Book id not found: " + id);
	}
}
