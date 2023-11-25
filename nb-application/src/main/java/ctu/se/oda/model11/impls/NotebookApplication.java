package ctu.se.oda.model11.impls;

import ctu.se.oda.model11.INotebookApplication;
import ctu.se.oda.model11.daos.INotebookDAO;
import ctu.se.oda.model11.models.commands.notebooks.CreateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.commands.notebooks.UpdateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NotebookApplication implements INotebookApplication {
    @Autowired
    private INotebookDAO notebookDAO;

    @Override
    public void create(CreateNotebookCommandReqDTO createNotebookCommandReqDTO) {
        notebookDAO.create(createNotebookCommandReqDTO);
    }

    @Override
    public void update(UpdateNotebookCommandReqDTO updateNotebookCommandReqDTO) {
        notebookDAO.update(updateNotebookCommandReqDTO);
    }

    @Override
    public void delete(UUID notebookId) {
        notebookDAO.delete(notebookId);
    }

    @Override
    public List<RetrieveNotebookQueryResDTO> list() {
        return notebookDAO.list();
    }

    @Override
    public RetrieveNotebookQueryResDTO retrieve(UUID notebookId) {
        return notebookDAO.retrieve(notebookId);
    }
}
