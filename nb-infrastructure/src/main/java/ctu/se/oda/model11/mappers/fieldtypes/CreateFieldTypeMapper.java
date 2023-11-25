package ctu.se.oda.model11.mappers.fieldtypes;

import ctu.se.oda.model11.entities.FieldType;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.fieldtypes.CreateFieldTypeCommandReqDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateFieldTypeMapper implements IInfrastructureMapper<CreateFieldTypeCommandReqDTO, FieldType> {
    @Override
    public FieldType convert(CreateFieldTypeCommandReqDTO source) {
        return FieldType.builder()
                .name(source.getName())
                .build();
    }
}
