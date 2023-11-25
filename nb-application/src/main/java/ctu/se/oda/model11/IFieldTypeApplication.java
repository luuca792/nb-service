package ctu.se.oda.model11;

import ctu.se.oda.model11.models.commands.fieldtypes.CreateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.commands.fieldtypes.UpdateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;

import java.util.List;

public interface IFieldTypeApplication {
    void create(CreateFieldTypeCommandReqDTO createFieldTypeCommandReqDTO);
    void update(UpdateFieldTypeCommandReqDTO updateFieldTypeCommandReqDTO);
    void delete(Long fieldTypeId);
    List<RetrieveFieldTypeQueryResDTO> list();
    RetrieveFieldTypeQueryResDTO retrieve(Long fieldTypeId);
}
