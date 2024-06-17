package library_api.manager.controller;

import library_api.manager.domain.model.Book;
import library_api.manager.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        var books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        var book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> create(@RequestBody Book book){
        var bookCreated = bookService.create(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{isbn}")
                .buildAndExpand(bookCreated.getISBN())
                .toUri();
        return ResponseEntity.created(location).body(bookCreated);
    }

    @PostMapping("/addBookList")
    public ResponseEntity<List<Book>> createList(@RequestBody List<Book> bookList){
        List<Book> cratedList = bookService.createList(bookList);
        return ResponseEntity.ok(cratedList);
    }
}
