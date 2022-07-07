package com.emids.bookAppFavourite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.emids.bookAppFavourite.entity.BookFavourite;
@CrossOrigin
@Repository
public interface FavouriteRepository extends MongoRepository<BookFavourite, Integer> {


	BookFavourite findByUsername(String username);

}
