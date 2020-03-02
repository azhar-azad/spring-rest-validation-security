package com.azad.practice.springrestvalidationsecurity.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String author;
	private BigDecimal price;

	public BookEntity() {
		super();
	}

	public BookEntity(String name, String author, BigDecimal price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
