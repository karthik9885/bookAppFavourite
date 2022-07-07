package com.emids.bookAppFavourite.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.emids.bookAppFavourite.entity.BookFavourite;
import com.emids.bookAppFavourite.exception.BookAlreadyExistsException;
import com.emids.bookAppFavourite.exception.BookNotFoundException;
import com.emids.bookAppFavourite.service.FavouriteService1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.andrewoma.dexx.collection.ArrayList;

import ch.qos.logback.core.net.ObjectWriter;
@WebMvcTest
class BookFavouriteControllerTest {
    @MockBean
	FavouriteService1 fs;
	
	@Autowired
	MockMvc mockmvc;
	

	
	
	@Test
	void testSavefavourite() throws BookAlreadyExistsException {
		BookFavourite fav=new BookFavourite(1, "My life", "Karthik", "pv", "everything is fine", "nothing", 200, "something is wrong", "all is well");
	when(fs.savefavourite(fav)).thenReturn("Added succesfully");
	}

	@Test
	void testGetAllFavouriteBooks() {
		List<BookFavourite> fav=new LinkedList<>();
    fav.add(new BookFavourite(1, "My life", "Karthik", "pv", "everything is fine", "nothing", 200, "something is wrong", "all is well"));
    when(fs.getAllFavouriteBooks()).thenReturn(fav);
	}

	@Test
	void testFindBookBybookTitle() {
		List<BookFavourite> fav=new LinkedList<BookFavourite>();
		fav.add(new BookFavourite(1, "My life", "Karthik", "pv", "everything is fine", "nothing", 200, "something is wrong", "all is well"));
		when(fs.findBookBybookTitle("My life")).thenReturn(fav);
	}

	@Test
	void testDeleteFromFavourite() throws BookNotFoundException {
		BookFavourite fav=new BookFavourite(1, "My life", "Karthik", "pv", "everything is fine", "nothing", 200, "something is wrong", "all is well");
	   when(fs.deleteFromFavourite(1)).thenReturn("Deleted successfully");
	}

}
