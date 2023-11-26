package ctu.se.oda.model11.repositories;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.entities.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IFieldRepository extends JpaRepository<Field, UUID> {
    List<Field> findByNotebook(Notebook notebook);
}
