package ctu.se.oda.model11.mappers.fields;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.fields.CreateFieldCommandReqDTO;
import ctu.se.oda.model11.repositories.IFieldTypeRepository;
import ctu.se.oda.model11.repositories.INoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateFieldMapper implements IInfrastructureMapper<CreateFieldCommandReqDTO, Field> {
    @Autowired
    private IFieldTypeRepository fieldTypeRepository;
    @Autowired
    private INoteBookRepository noteBookRepository;

    @Override
    public Field convert(CreateFieldCommandReqDTO source) {
        var optionalNotebook = noteBookRepository.findById(UUID.fromString(source.getNotebookId()));
        var optionalFieldType = fieldTypeRepository.findById(source.getFieldTypeId());
        if (optionalNotebook.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.NOTEBOOK_NOT_FOUND_BY_ID);
        }
        if (optionalFieldType.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.FIELD_TYPE_NOT_FOUND_BY_ID);
        }
        return Field.builder()
                .name(source.getName())
                .fieldType(optionalFieldType.get())
                .notebook(optionalNotebook.get())
                .build();
    }
}
