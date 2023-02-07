package com.manikanta.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikanta.library.Entity.Book;
import com.manikanta.library.Reposiotory.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book) ;
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public Book getBook(String id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		 bookRepository.deleteById(id);
	}

	public String updateBook(Book book, String id) {
 Optional<Book> opBook =bookRepository.findById(id);
 if(opBook.isPresent()) {
 Book bok= opBook.get();
 bok.setAuthor(book.getAuthor());
 bok.setGenre(book.getGenre());
bok.setTitle(book.getTitle());
bookRepository.save(bok);
}
 return "updated sucessfully";
}

	public Book getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return bookRepository.findByTitle(title);
	}

	public Book getBookByGenre(String genre) {
		// TODO Auto-generated method stub
		return bookRepository.findByGenre(genre);
	}



	public List<Book> getAllBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return bookRepository.findAllByAuthor(author);
	}

	public List<Book> getAllBooksByGenre(String genre) {
		// TODO Auto-generated method stub
		return bookRepository.findAllByGenre(genre);
	}

}
