package dev.batuhanyetgin.msbookservice.repository;

import dev.batuhanyetgin.msbookservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    BookEntity getByIsbn(Long isbn);

    boolean existsByIsbn(Long aLong);
}
