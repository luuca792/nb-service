package ctu.se.oda.model11.repositories;

import ctu.se.oda.model11.entities.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface INoteBookRepository extends JpaRepository<Notebook, UUID> {
}
