package ctu.se.oda.model11.mappers.values;

import ctu.se.oda.model11.entities.Value;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.values.UpdateValueCommandReqDTO;
import ctu.se.oda.model11.repositories.IValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateValueMapper implements IInfrastructureMapper<UpdateValueCommandReqDTO, Value> {
    @Autowired
    private IValueRepository valueRepository;

    @Override
    public Value convert(UpdateValueCommandReqDTO source) {
        var optionalValue = valueRepository.findById(UUID.fromString(source.getId()));
        if (optionalValue.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.VALUE_NOT_FOUND_BY_ID);
        }
        return Value.builder()
                .id(optionalValue.get().getId())
                .value(Objects.isNull(source.getValue()) ? optionalValue.get().getValue() : source.getValue())
                .field(optionalValue.get().getField())
                .build();
    }
}
