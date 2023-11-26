package ctu.se.oda.model11.daos;

import ctu.se.oda.model11.entities.Value;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.values.CreateValueCommandReqDTO;
import ctu.se.oda.model11.models.commands.values.UpdateValueCommandReqDTO;
import ctu.se.oda.model11.models.queries.values.RetrieveValueQueryResDTO;
import ctu.se.oda.model11.repositories.IValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ValueDAO implements IValueDAO{
    @Autowired
    private IValueRepository valueRepository;
    @Autowired
    private IInfrastructureMapper<CreateValueCommandReqDTO, Value> createMapper;
    @Autowired
    private IInfrastructureMapper<UpdateValueCommandReqDTO, Value> updateMapper;
    @Autowired
    private IInfrastructureMapper<Value, RetrieveValueQueryResDTO> retrieveMapper;

    @Override
    public void create(CreateValueCommandReqDTO createValueCommandReqDTO) {
        valueRepository.save(createMapper.convert(createValueCommandReqDTO));
    }

    @Override
    public void update(UpdateValueCommandReqDTO updateValueCommandReqDTO) {
        valueRepository.save(updateMapper.convert(updateValueCommandReqDTO));
    }

    @Override
    public void delete(UUID valueId) {
        valueRepository.deleteById(valueId);
    }

    @Override
    public List<RetrieveValueQueryResDTO> list() {
        return valueRepository.findAll().stream().map(value -> retrieveMapper.convert(value)).collect(Collectors.toList());
    }

    @Override
    public RetrieveValueQueryResDTO retrieve(UUID valueId) {
        var optionalValue = valueRepository.findById(valueId);
        if (optionalValue.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.VALUE_NOT_FOUND_BY_ID);
        }
        return retrieveMapper.convert(optionalValue.get());
    }
}
