package com.emids.bookAppFavourite.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.emids.bookAppFavourite.entity.BookFavourite;
import com.emids.bookAppFavourite.exception.BookAlreadyExistsException;
import com.emids.bookAppFavourite.exception.BookNotFoundException;
import com.emids.bookAppFavourite.repository.FavouriteRepository;
@Service
public class FavouriteService1 {
    @Autowired
    FavouriteRepository favrepo;
	public String deleteById;
	
	public BookFavourite savefavourite(BookFavourite f) throws BookAlreadyExistsException
	{

   		
		
		if(favrepo.existsById(f.getBookId()))
		{
			throw new BookAlreadyExistsException();
		}
		BookFavourite savedfavourites=favrepo.save(f);
		return savedfavourites;
	}

     public List<BookFavourite> getAllFavouriteBooks()
   	{
		List<BookFavourite> favouritelist=favrepo.findAll();
		return favouritelist;
	}
  
     public BookFavourite findBookById(int bookId)
     {
    	 return favrepo.findById(bookId).get();
     }
     
     public BookFavourite findBookByUsername(String username)
     {
    	 BookFavourite favourites=favrepo.findByUsername(username);
    			 return favourites;
     }
     
	public String deleteFromFavourite(int bookId) throws BookNotFoundException
	{
		if(favrepo.existsById(bookId))
		{
			favrepo.deleteById(bookId);
		}
		else
		{
			throw new BookNotFoundException("No book to delete");
		}
		return "deleted";
	}
}