package com.manikanta.library.Reposiotory;

import java.util.List;

import com.manikanta.library.Entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {

	Book findByGenre(String genre);

	Book findByTitle(String title);

	List<Book> findAllByAuthor(String author);

	List<Book> findAllByGenre(String genre);

}
