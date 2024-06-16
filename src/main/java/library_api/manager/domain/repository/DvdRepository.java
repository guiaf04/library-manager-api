package library_api.manager.domain.repository;

import library_api.manager.domain.model.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
}
