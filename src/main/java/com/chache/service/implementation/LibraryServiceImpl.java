package com.chache.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.chache.dto.BookRequest;
import com.chache.dto.BookResponse;
import com.chache.entity.Book;
import com.chache.repository.LibraryRepository;
import com.chache.service.LibraryService;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryServiceImpl.class);

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	@Cacheable(cacheNames = "books", key = "#bookId")
	public BookResponse findById(String bookId) {
		LOGGER.info("Getting book details");
		Optional<Book> findById = libraryRepository.findById(bookId);
		LOGGER.info("Getting book details from db");
		BookResponse bookResponse = null;
		if (findById.isPresent()) {
			bookResponse = setBookResponse(findById.get());
		}
		return bookResponse;
	}

	@Override
	public BookResponse createBook(BookRequest bookRequest) {
		Book book = setBook(bookRequest);
		book = libraryRepository.save(book);
		LOGGER.info("Book is created");
		return setBookResponse(book);
	}

	@Override
	@CachePut(cacheNames = "books", key = "#bookRequest.bookId")
	public BookResponse updateBook(BookRequest bookRequest) {
		Optional<Book> findById = libraryRepository.findById(bookRequest.getBookId());
		BookResponse bookResponse = null;
		if (findById.isPresent()) {
			Book book = updateBook(bookRequest, findById.get().getBookId());
			libraryRepository.save(book);
			LOGGER.info("Book is updated");
			bookResponse = setBookResponse(findById.get());
		}
		return bookResponse;
	}

	private Book updateBook(BookRequest bookRequest, String bookId) {
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(bookRequest.getBookName());
		return book;
	}

	@Override
	@CacheEvict(cacheNames = "books", key = "#bookId")
	public BookResponse deleteBook(String bookId) {
		Optional<Book> findById = libraryRepository.findById(bookId);
		BookResponse bookResponse = null;
		if (findById.isPresent()) {
			libraryRepository.delete(findById.get());
			LOGGER.info("Book is deleted.");
			bookResponse = setBookResponse(findById.get());
		}
		return bookResponse;
	}

	private Book setBook(BookRequest bookRequest) {
		Book book = new Book();
		book.setBookId(bookRequest.getBookId());
		book.setBookName(bookRequest.getBookName());
		return book;
	}

	private BookResponse setBookResponse(Book book) {
		BookResponse bookResponse = new BookResponse();
		bookResponse.setBookId(book.getBookId());
		bookResponse.setBookName(book.getBookName());
		return bookResponse;
	}

}
