package ctu.se.oda.model11.impls;

import ctu.se.oda.model11.IFieldApplication;
import ctu.se.oda.model11.daos.IFieldDAO;
import ctu.se.oda.model11.models.commands.fields.CreateFieldCommandReqDTO;
import ctu.se.oda.model11.models.commands.fields.UpdateFieldCommandReqDTO;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FieldApplication implements IFieldApplication {
    @Autowired
    private IFieldDAO fieldDAO;

    @Override
    public void create(CreateFieldCommandReqDTO createFieldCommandReqDTO) {
        fieldDAO.create(createFieldCommandReqDTO);
    }

    @Override
    public void update(UpdateFieldCommandReqDTO updateFieldCommandReqDTO) {
        fieldDAO.update(updateFieldCommandReqDTO);
    }

    @Override
    public void delete(UUID fieldId) {
        fieldDAO.delete(fieldId);
    }

    @Override
    public List<RetrieveFieldQueryResDTO> list() {
        return fieldDAO.list();
    }

    @Override
    public List<RetrieveFieldQueryResDTO> listByNotebookId(UUID notebookId) {
        return fieldDAO.listByNotebookId(notebookId);
    }

    @Override
    public List<RetrieveFieldQueryResDTO> listByTaskId(UUID taskId) {
        return fieldDAO.listByTaskId(taskId);
    }

    @Override
    public List<RetrieveFieldQueryResDTO> listByNotebookIdAndTaskId(UUID notebookId, UUID taskId) {
        return fieldDAO.listByNotebookIdAndTaskId(notebookId, taskId);
    }

    @Override
    public RetrieveFieldQueryResDTO retrieve(UUID fieldId) {
        return fieldDAO.retrieve(fieldId);
    }
}
