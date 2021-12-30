package com.chache.service;

import com.chache.dto.BookRequest;
import com.chache.dto.BookResponse;

public interface LibraryService {

	public BookResponse findById(String bookId);

	public BookResponse createBook(BookRequest book);

	public BookResponse updateBook(BookRequest bookRequest);

	public BookResponse deleteBook(String bookId);

}
