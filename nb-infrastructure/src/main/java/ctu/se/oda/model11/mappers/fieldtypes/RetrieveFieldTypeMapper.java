package ctu.se.oda.model11.mappers.fieldtypes;

import ctu.se.oda.model11.entities.FieldType;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import org.springframework.stereotype.Component;

@Component
public class RetrieveFieldTypeMapper implements IInfrastructureMapper<FieldType, RetrieveFieldTypeQueryResDTO> {
    @Override
    public RetrieveFieldTypeQueryResDTO convert(FieldType source) {
        return RetrieveFieldTypeQueryResDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
