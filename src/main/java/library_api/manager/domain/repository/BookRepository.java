package library_api.manager.domain.repository;

import library_api.manager.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsBookByISBN(String isbn);
}
