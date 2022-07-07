package com.emids.bookAppFavourite.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.emids.bookAppFavourite.entity.BookFavourite;
import com.emids.bookAppFavourite.exception.BookAlreadyExistsException;
import com.emids.bookAppFavourite.exception.BookNotFoundException;
import com.emids.bookAppFavourite.service.FavouriteService1;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@CrossOrigin(origins = "*")
@RestController
//@EnableSwagger2
public class BookFavouriteController {
	
    @Autowired
	FavouriteService1 fs;
    
    /*@GetMapping("/bookApp")
    	public String myBook()
    	{
    		return "Welcome to Book store"; 
    	}*/
   
    
    @PostMapping("/bookApp")
 	public String savefavourite( @RequestBody BookFavourite f)  throws BookAlreadyExistsException
 	{
		return fs.savefavourite(f);
 	}
    
    @GetMapping("/bookApp")
    public List<BookFavourite> getAllFavouriteBooks()
    {
    	List<BookFavourite> allfavourites=fs.getAllFavouriteBooks();
    	return allfavourites;
    }
    @GetMapping("/bookApp/{bookId}")
    public BookFavourite findBookById(@PathVariable int bookId)
    {
    	return fs.findBookById(bookId);
    }
    
    @GetMapping("/bookApp/get/{bookTitle}")
    public List<BookFavourite> findBookBybookTitle(@PathVariable String bookTitle)
    {
    	return fs.findBookBybookTitle(bookTitle);
    }
    
	@DeleteMapping("/bookApp/delete/{bookId}") 
	public String deleteFromFavourite(@PathVariable int bookId) throws BookNotFoundException
	{
		return fs.deleteFromFavourite(bookId);
	}
	
	
	/*@GetMapping("/bookApp/getFavourites/{username}")
	public ResponseEntity<?> getBookById (@PathVariable ("id") Integer id, @PathVariable("username") String username)
	{
		
		ResponseEntity<?> rs=null;
		try {
			List<NoteBookFavourite> b=fs.getAllFavourite(id, username);
			rs=ResponseEntity.status(HttpStatus.OK).body(b);
		}
		catch(Exception e)
		{
			rs=ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;
	}
	@GetMapping("/bookApp/getFavouriteBooksByIdAndUsername/{id}/{username}")
	/*public ResponseEntity<?> getBookByFavouriteByIdAndUsername (@PathVariable("id") Integer id,@PathVariable ("username") String username)
	{
		
		ResponseEntity<?> rs=null;
		try {
			List<NoteBookFavourite> b=fs.getFavouriteBooksByIdAndUsername(id, username);
			rs=ResponseEntity.status(HttpStatus.OK).body(b);
		}
		catch(Exception e)
		{
			rs=ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;
	}
	
	@PostMapping("/bookApp/addToFavourites")
	public ResponseEntity<?> saveBook(@RequestBody NoteBookFavourite b)
	{
		ResponseEntity<?> rs=null;
		try
		{
			NoteBookFavourite bk=fs.savefavourite(b);
			if(bk!=null)
			{
				rs=ResponseEntity.status(HttpStatus.CREATED).build();
			}
			else
			{
				rs=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		catch(Exception e)
		{
			rs=ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;
	}
	 @DeleteMapping("/bookApp/deleteFromFavourite/{id}/{username}")
	  public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id, @PathVariable("username") String username) {
	   
	    ResponseEntity<?> rs=null;
		
			
			fs.deleteFromFavourite(id);
			
			
			rs=ResponseEntity.status(HttpStatus.OK).build();
			
		
		return rs;
	   
	  }*/
	
	
	
}
