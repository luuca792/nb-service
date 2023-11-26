package ctu.se.oda.model11.impls;

import ctu.se.oda.model11.IValueApplication;
import ctu.se.oda.model11.daos.IValueDAO;
import ctu.se.oda.model11.models.commands.values.CreateValueCommandReqDTO;
import ctu.se.oda.model11.models.commands.values.UpdateValueCommandReqDTO;
import ctu.se.oda.model11.models.queries.values.RetrieveValueQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ValueApplication implements IValueApplication {
    @Autowired
    private IValueDAO valueDAO;

    @Override
    public void create(CreateValueCommandReqDTO createValueCommandReqDTO) {
        valueDAO.create(createValueCommandReqDTO);
    }

    @Override
    public void update(UpdateValueCommandReqDTO updateValueCommandReqDTO) {
        valueDAO.update(updateValueCommandReqDTO);
    }

    @Override
    public void delete(UUID valueId) {
        valueDAO.delete(valueId);
    }

    @Override
    public List<RetrieveValueQueryResDTO> list() {
        return valueDAO.list();
    }

    @Override
    public RetrieveValueQueryResDTO retrieve(UUID valueId) {
        return valueDAO.retrieve(valueId);
    }
}
