package ctu.se.oda.model11.repositories;

import ctu.se.oda.model11.entities.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IValueRepository extends JpaRepository<Value, UUID> {
}
