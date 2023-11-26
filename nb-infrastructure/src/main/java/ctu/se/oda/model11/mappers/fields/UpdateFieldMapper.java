package ctu.se.oda.model11.mappers.fields;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.fields.UpdateFieldCommandReqDTO;
import ctu.se.oda.model11.repositories.IFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateFieldMapper implements IInfrastructureMapper<UpdateFieldCommandReqDTO, Field> {
    @Autowired
    private IFieldRepository fieldRepository;

    @Override
    public Field convert(UpdateFieldCommandReqDTO source) {
        var optionalField = fieldRepository.findById(UUID.fromString(source.getId()));
        if (optionalField.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.FIELD_NOT_FOUND_BY_ID);
        }
        return Field.builder()
                .id(optionalField.get().getId())
                .name(Objects.isNull(source.getName()) ? optionalField.get().getName() : source.getName())
                .notebook(optionalField.get().getNotebook())
                .fieldType(optionalField.get().getFieldType())
                .build();
    }
}
