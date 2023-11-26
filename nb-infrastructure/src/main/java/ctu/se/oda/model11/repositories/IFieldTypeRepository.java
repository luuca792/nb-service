package ctu.se.oda.model11.repositories;

import ctu.se.oda.model11.entities.FieldType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldTypeRepository extends JpaRepository<FieldType, Long> {
}
