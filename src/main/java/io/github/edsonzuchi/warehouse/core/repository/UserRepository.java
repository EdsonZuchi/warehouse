package io.github.edsonzuchi.warehouse.core.repository;

import io.github.edsonzuchi.warehouse.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
