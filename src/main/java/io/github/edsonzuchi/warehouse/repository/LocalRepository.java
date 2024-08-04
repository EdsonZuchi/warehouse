package io.github.edsonzuchi.warehouse.repository;

import io.github.edsonzuchi.warehouse.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
