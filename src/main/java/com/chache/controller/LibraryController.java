package com.chache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chache.dto.BookRequest;
import com.chache.dto.BookResponse;
import com.chache.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@PostMapping(value = "/save")
	public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest) {
		return ResponseEntity.ok(libraryService.createBook(bookRequest));
	}

	@PutMapping(value = "/update")
	public ResponseEntity<BookResponse> updateBook(@RequestBody BookRequest bookRequest) {
		return ResponseEntity.ok(libraryService.updateBook(bookRequest));
	}

	@GetMapping(value = "/find/{bookId}")
	public ResponseEntity<BookResponse> findByBookId(String bookId) {
		return ResponseEntity.ok(libraryService.findById(bookId));
	}

	@DeleteMapping(value = "/find/{bookId}")
	public ResponseEntity<BookResponse> deleteByBookId(String bookId) {
		return ResponseEntity.ok(libraryService.deleteBook(bookId));
	}

}
