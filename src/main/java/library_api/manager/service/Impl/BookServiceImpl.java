package library_api.manager.service.Impl;

import library_api.manager.domain.model.Book;
import library_api.manager.domain.repository.BookRepository;
import library_api.manager.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book create(Book book) {
        if(bookRepository.existsBookByISBN(book.getISBN())){
            throw new IllegalArgumentException("This book already exists");
        }
        return bookRepository.save(book);
    }

    @Override
    public List<Book> createList(List<Book> bookList){
        List<Book> bookUnique = bookList.stream()
                .filter(x -> !bookRepository.existsBookByISBN(x.getISBN()))
                .toList();

        return bookRepository.saveAll(bookUnique);
    }
}
