package library_api.manager.domain.repository;

import library_api.manager.domain.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine, String> {
}
