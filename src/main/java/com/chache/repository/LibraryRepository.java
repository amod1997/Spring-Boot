package com.chache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chache.entity.Book;

@Repository
public interface LibraryRepository extends JpaRepository<Book, String>{

}
