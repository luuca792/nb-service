package ctu.se.oda.model11.mappers.fieldtypes;

import ctu.se.oda.model11.entities.FieldType;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.fieldtypes.UpdateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.repositories.IFieldTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UpdateFieldTypeMapper implements IInfrastructureMapper<UpdateFieldTypeCommandReqDTO, FieldType> {
    @Autowired
    private IFieldTypeRepository fieldTypeRepository;

    @Override
    public FieldType convert(UpdateFieldTypeCommandReqDTO source) {
        var optionalFieldType = fieldTypeRepository.findById(source.getId());
        if (optionalFieldType.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.FIELD_TYPE_NOT_FOUND_BY_ID);
        }
        return FieldType.builder()
                .id(source.getId())
                .name(Objects.isNull(source.getName()) ? optionalFieldType.get().getName() : source.getName())
                .build();
    }
}
