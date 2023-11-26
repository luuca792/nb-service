package ctu.se.oda.model11;

import ctu.se.oda.model11.models.commands.fields.CreateFieldCommandReqDTO;
import ctu.se.oda.model11.models.commands.fields.UpdateFieldCommandReqDTO;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;

import java.util.List;
import java.util.UUID;

public interface IFieldApplication {
    void create(CreateFieldCommandReqDTO createFieldCommandReqDTO);
    void update(UpdateFieldCommandReqDTO updateFieldCommandReqDTO);
    void delete(UUID fieldId);
    List<RetrieveFieldQueryResDTO> list();
    List<RetrieveFieldQueryResDTO> listByNotebookId(UUID notebookId);
    RetrieveFieldQueryResDTO retrieve(UUID fieldId);
}
