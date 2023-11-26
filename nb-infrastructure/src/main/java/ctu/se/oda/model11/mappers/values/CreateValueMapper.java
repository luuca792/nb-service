package ctu.se.oda.model11.mappers.values;

import ctu.se.oda.model11.entities.Value;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.values.CreateValueCommandReqDTO;
import ctu.se.oda.model11.repositories.IFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateValueMapper implements IInfrastructureMapper<CreateValueCommandReqDTO, Value> {
    @Autowired
    private IFieldRepository fieldRepository;

    @Override
    public Value convert(CreateValueCommandReqDTO source) {
        var optionalField = fieldRepository.findById(UUID.fromString(source.getFieldId()));
        if (optionalField.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.FIELD_NOT_FOUND_BY_ID);
        }
        return Value.builder()
                .value(source.getValue())
                .field(optionalField.get())
                .build();
    }
}
