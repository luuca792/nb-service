package ctu.se.oda.model11.repositories;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.entities.FieldTask;
import ctu.se.oda.model11.entities.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IFieldTaskRepository extends JpaRepository<FieldTask, UUID> {
    List<FieldTask> findByTaskId(UUID taskId);
    void deleteAllByField(Field field);
}
