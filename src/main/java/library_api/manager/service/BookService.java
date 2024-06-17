package library_api.manager.service;

import library_api.manager.domain.model.Book;

import java.util.List;

public interface BookService extends CrudService<Book,Long>{
    public List<Book> createList(List<Book> bookList);
}
