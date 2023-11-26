package ctu.se.oda.model11.mappers.values;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.entities.FieldType;
import ctu.se.oda.model11.entities.Notebook;
import ctu.se.oda.model11.entities.Value;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;
import ctu.se.oda.model11.models.queries.values.RetrieveValueQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveValueMapper implements IInfrastructureMapper<Value, RetrieveValueQueryResDTO> {
    @Override
    public RetrieveValueQueryResDTO convert(Value source) {
        return RetrieveValueQueryResDTO.builder()
                .id(source.getId().toString())
                .value(source.getValue())
                .fieldId(source.getField().getId().toString())
                .build();
    }
}
