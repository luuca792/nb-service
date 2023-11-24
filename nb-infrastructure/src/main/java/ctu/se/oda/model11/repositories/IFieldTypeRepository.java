package ctu.se.oda.model11.repositories;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.entities.FieldType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFieldTypeRepository extends JpaRepository<FieldType, Long> {
}
