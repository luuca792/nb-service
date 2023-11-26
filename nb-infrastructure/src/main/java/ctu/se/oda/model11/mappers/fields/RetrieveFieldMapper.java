package ctu.se.oda.model11.mappers.fields;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.entities.FieldType;
import ctu.se.oda.model11.entities.Notebook;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;
import ctu.se.oda.model11.repositories.IFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetrieveFieldMapper implements IInfrastructureMapper<Field, RetrieveFieldQueryResDTO> {
    @Autowired
    private IInfrastructureMapper<FieldType, RetrieveFieldTypeQueryResDTO> retrieveFieldTypeMapper;
    @Autowired
    private IInfrastructureMapper<Notebook, RetrieveNotebookQueryResDTO> retrieveNotebookMapper;

    @Override
    public RetrieveFieldQueryResDTO convert(Field source) {
        return RetrieveFieldQueryResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .fieldType(retrieveFieldTypeMapper.convert(source.getFieldType()))
                .notebook(retrieveNotebookMapper.convert(source.getNotebook()))
                .build();
    }
}
