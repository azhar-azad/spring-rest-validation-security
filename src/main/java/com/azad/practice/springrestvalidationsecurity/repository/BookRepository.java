package com.azad.practice.springrestvalidationsecurity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.springrestvalidationsecurity.entity.BookEntity;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long> {

}
