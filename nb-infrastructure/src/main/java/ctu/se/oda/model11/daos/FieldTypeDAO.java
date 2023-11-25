package ctu.se.oda.model11.daos;

import ctu.se.oda.model11.entities.FieldType;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.fieldtypes.CreateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.commands.fieldtypes.UpdateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import ctu.se.oda.model11.repositories.IFieldTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldTypeDAO implements IFieldTypeDAO{
    @Autowired
    private IFieldTypeRepository fieldTypeRepository;
    @Autowired
    private IInfrastructureMapper<CreateFieldTypeCommandReqDTO, FieldType> createMapper;
    @Autowired
    private IInfrastructureMapper<UpdateFieldTypeCommandReqDTO, FieldType> updateMapper;
    @Autowired
    private IInfrastructureMapper<FieldType, RetrieveFieldTypeQueryResDTO> retrieveMapper;

    @Override
    public void create(CreateFieldTypeCommandReqDTO createFieldTypeCommandReqDTO) {
        fieldTypeRepository.save(createMapper.convert(createFieldTypeCommandReqDTO));
    }

    @Override
    public void update(UpdateFieldTypeCommandReqDTO updateFieldTypeCommandReqDTO) {
        fieldTypeRepository.save(updateMapper.convert(updateFieldTypeCommandReqDTO));
    }

    @Override
    public void delete(Long fieldTypeId) {
        fieldTypeRepository.deleteById(fieldTypeId);
    }

    @Override
    public List<RetrieveFieldTypeQueryResDTO> list() {
        return fieldTypeRepository.findAll().stream().map(
                fieldType -> retrieveMapper.convert(fieldType)
        ).collect(Collectors.toList());
    }

    @Override
    public RetrieveFieldTypeQueryResDTO retrieve(Long fieldTypeId) {
        var optionalFieldType = fieldTypeRepository.findById(fieldTypeId);
        if (optionalFieldType.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.FIELD_TYPE_NOT_FOUND_BY_ID);
        }
        return retrieveMapper.convert(optionalFieldType.get());
    }
}
