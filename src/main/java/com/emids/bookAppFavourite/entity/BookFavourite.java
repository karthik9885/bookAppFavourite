package com.emids.bookAppFavourite.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="favourites")
public class BookFavourite  {
	@Id
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublisher;
	private String bookDescription;
	private String bookCategory;
	private int bookPrice;
	private String bookLanguage;
	private String bookImage;
	public BookFavourite(String bookImage) {
		super();
		this.bookImage = bookImage;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	private String username;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookLanguage() {
		return bookLanguage;
	}
	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
	public BookFavourite(int bookId, String bookTitle, String bookAuthor, String bookPublisher,
			 String bookDescription, String bookCategory, int bookPrice,
			String bookLanguage, String username) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookDescription = bookDescription;
		this.bookCategory = bookCategory;
		this.bookPrice = bookPrice;
		this.bookLanguage = bookLanguage;
		this.username = username;
	}
	public BookFavourite() {
		super();
	}
}
