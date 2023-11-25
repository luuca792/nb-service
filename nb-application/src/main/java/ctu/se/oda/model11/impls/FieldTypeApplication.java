package ctu.se.oda.model11.impls;

import ctu.se.oda.model11.IFieldTypeApplication;
import ctu.se.oda.model11.daos.IFieldTypeDAO;
import ctu.se.oda.model11.models.commands.fieldtypes.CreateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.commands.fieldtypes.UpdateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FieldTypeApplication implements IFieldTypeApplication {
    @Autowired
    private IFieldTypeDAO fieldTypeDAO;

    @Override
    public void create(CreateFieldTypeCommandReqDTO createFieldTypeCommandReqDTO) {
        fieldTypeDAO.create(createFieldTypeCommandReqDTO);
    }

    @Override
    public void update(UpdateFieldTypeCommandReqDTO updateFieldTypeCommandReqDTO) {
        fieldTypeDAO.update(updateFieldTypeCommandReqDTO);
    }

    @Override
    public void delete(Long fieldTypeId) {
        fieldTypeDAO.delete(fieldTypeId);
    }

    @Override
    public List<RetrieveFieldTypeQueryResDTO> list() {
        return fieldTypeDAO.list();
    }

    @Override
    public RetrieveFieldTypeQueryResDTO retrieve(Long fieldTypeId) {
        return fieldTypeDAO.retrieve(fieldTypeId);
    }
}
