package com.chris.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.main.models.Book;
import com.chris.main.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
        return bookRepository.save(b);
    }

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public void deleteBook(Book b) {
		bookRepository.deleteById(b.getId());
	}
	public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
        Book book = new Book(title, description, language, numOfPages);
        book.setId(id);
		bookRepository.save(book);
		return book;
    }
}
