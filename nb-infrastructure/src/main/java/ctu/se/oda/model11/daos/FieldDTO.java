package ctu.se.oda.model11.daos;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.fields.CreateFieldCommandReqDTO;
import ctu.se.oda.model11.models.commands.fields.UpdateFieldCommandReqDTO;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import ctu.se.oda.model11.repositories.IFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FieldDTO implements IFieldDAO{
    @Autowired
    private IFieldRepository fieldRepository;
    @Autowired
    private IInfrastructureMapper<CreateFieldCommandReqDTO, Field> createMapper;
    @Autowired
    private IInfrastructureMapper<UpdateFieldCommandReqDTO, Field> updateMapper;
    @Autowired
    private IInfrastructureMapper<Field, RetrieveFieldQueryResDTO> retrieveMapper;

    @Override
    public void create(CreateFieldCommandReqDTO createFieldCommandReqDTO) {
        fieldRepository.save(createMapper.convert(createFieldCommandReqDTO));
    }

    @Override
    public void update(UpdateFieldCommandReqDTO updateFieldCommandReqDTO) {
        fieldRepository.save(updateMapper.convert(updateFieldCommandReqDTO));
    }

    @Override
    public void delete(UUID fieldId) {
        fieldRepository.deleteById(fieldId);
    }

    @Override
    public List<RetrieveFieldQueryResDTO> list() {
        return fieldRepository.findAll().stream().map(field -> retrieveMapper.convert(field)).collect(Collectors.toList());
    }

    @Override
    public RetrieveFieldQueryResDTO retrieve(UUID fieldId) {
        var optionalField = fieldRepository.findById(fieldId);
        if (optionalField.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.FIELD_NOT_FOUND_BY_ID);
        }
        return retrieveMapper.convert(optionalField.get());
    }
}
