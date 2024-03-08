package dev.batuhanyetgin.mssecurityservice.repository;

import dev.batuhanyetgin.mssecurityservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    UserEntity getByEmail(String email);
}
