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
	
	public String savefavourite(BookFavourite f) throws BookAlreadyExistsException
	{
      try {
		if(favrepo.existsById(f.getBookId()))
		{
			throw new BookAlreadyExistsException();
			
		}
		else {
		BookFavourite savedfavourites=favrepo.save(f);
		return "Added succesfully";}
      }
      catch(BookAlreadyExistsException e)
      {
    	  e.printStackTrace();
      }
      return "Already exists";
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
     
     public List<BookFavourite> findBookBybookTitle(String bookTitle)
     {
    	 List<BookFavourite> searchlist=findBookBybookTitle(bookTitle);
    	 return searchlist;
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