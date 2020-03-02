package com.azad.practice.springrestvalidationsecurity.exception;

import java.util.Set;

public class BookUnSupportedFieldPatchException extends RuntimeException {

	private static final long serialVersionUID = 4868925806646840715L;
	
	public BookUnSupportedFieldPatchException(Set<String> keys) {
		super("Field " + keys.toString() + " update is not allowed.");
	}

}
